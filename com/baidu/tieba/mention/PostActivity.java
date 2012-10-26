package com.baidu.tieba.mention;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.ContentData;
import com.baidu.tieba.data.PbData;
import com.baidu.tieba.data.PostData;
import com.baidu.tieba.model.PbModel;
import com.baidu.tieba.pb.ImageActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.AsyncImageLoader;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.NetWork;
import com.baidu.tieba.util.StringHelper;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.CustomTextView;
import com.baidu.tieba.write.WriteActivity;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class PostActivity extends BaseActivity {
    private static final String PARAM_PID = "pid";
    private static final String PARAM_TID = "tid";
    private TextView mFloorText;
    private AsyncImageLoader mImageLoader;
    private boolean mIsShowImages;
    private ImageView mPhoto;
    private TextView mRank;
    private LinearLayout mSeg;
    private TextView mText;
    private int mTextConfig;
    private TextView mTime;
    private TextView mUserName;
    private LinearLayout mPost = null;
    private TextView mTitleText = null;
    private Button mReply = null;
    private Button mBack = null;
    private ProgressBar mProgress = null;
    private String mTid = null;
    private String mPid = null;
    private PostAsyncTask mTask = null;
    private PbModel mModel = null;

    public static void startAcitivity(Context context, String threadId, String postId) {
        Intent intent = new Intent(context, PostActivity.class);
        if (threadId != null && threadId.length() > 0 && postId != null && postId.length() > 0) {
            intent.putExtra(PARAM_TID, threadId);
            intent.putExtra(PARAM_PID, postId);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_activity);
        initUI();
        if (savedInstanceState != null) {
            this.mTid = savedInstanceState.getString(PARAM_TID);
            this.mPid = savedInstanceState.getString(PARAM_PID);
        } else {
            Intent intent = getIntent();
            this.mTid = intent.getStringExtra(PARAM_TID);
            this.mPid = intent.getStringExtra(PARAM_PID);
        }
        this.mImageLoader = new AsyncImageLoader(this);
        this.mModel = new PbModel();
        startAsyncTask();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onResume() {
        if (this.mTextConfig != TiebaApplication.app.getFontSize()) {
            this.mTextConfig = TiebaApplication.app.getFontSize();
            this.mUserName.setTextSize(Config.getNameSize());
            this.mText.setTextSize(Config.getContentSize());
            refreshActivity();
        }
        if (this.mIsShowImages != TiebaApplication.app.isShowImages()) {
            this.mIsShowImages = TiebaApplication.app.isShowImages();
            refreshActivity();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            cancelAsyncTask();
            if (this.mModel != null) {
                if (this.mModel.getData() != null) {
                    this.mModel.setData(null);
                }
                this.mModel = null;
            }
            this.mProgress.setVisibility(8);
            System.gc();
        } catch (Exception e) {
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(PARAM_TID, this.mTid);
        outState.putString(PARAM_PID, this.mPid);
    }

    private void initUI() {
        this.mTitleText = (TextView) findViewById(R.id.titel_text);
        this.mPost = (LinearLayout) findViewById(R.id.post);
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mention.PostActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PostActivity.this.finish();
            }
        });
        this.mReply = (Button) findViewById(R.id.reply);
        this.mReply.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mention.PostActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (PostActivity.this.mModel != null && PostActivity.this.mModel.getData() != null) {
                    PbData data = PostActivity.this.mModel.getData();
                    PostData post = data.getPost_list().get(0);
                    if (post != null) {
                        WriteActivity.startAcitivity(PostActivity.this, data.getForum().getId(), data.getForum().getName(), data.getThread().getId(), post.getId(), post.getFloor_num(), data.getAnti(), PostActivity.this.mModel.getData().getIsHasFloor());
                    }
                }
            }
        });
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mProgress.setVisibility(8);
        this.mPhoto = (ImageView) findViewById(R.id.photo);
        this.mPhoto.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mention.PostActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (PostActivity.this.mModel != null && PostActivity.this.mModel.getData() != null) {
                    PbData data = PostActivity.this.mModel.getData();
                    PostData post = data.getPost_list().get(0);
                    if (post != null) {
                        PersonInfoActivity.startActivity(PostActivity.this, post.getAuthor().getId(), post.getAuthor().getName());
                    }
                }
            }
        });
        this.mUserName = (TextView) findViewById(R.id.user_name);
        this.mUserName.getPaint().setFakeBoldText(true);
        this.mFloorText = (TextView) findViewById(R.id.floor);
        this.mFloorText.setVisibility(8);
        this.mRank = (TextView) findViewById(R.id.rank);
        this.mTime = (TextView) findViewById(R.id.time);
        this.mText = (TextView) findViewById(R.id.text);
        this.mText.setMovementMethod(LinkMovementMethod.getInstance());
        this.mText.setFocusable(false);
        this.mText.setLineSpacing(0.0f, 1.2f);
        this.mSeg = (LinearLayout) findViewById(R.id.seg);
        this.mUserName.setTextSize(Config.getNameSize());
        this.mText.setTextSize(Config.getContentSize());
        this.mTextConfig = TiebaApplication.app.getFontSize();
        this.mIsShowImages = TiebaApplication.app.isShowImages();
    }

    private void cancelAsyncTask() {
        if (this.mTask != null) {
            this.mTask.cancel();
            this.mTask = null;
        }
        if (this.mImageLoader != null) {
            this.mImageLoader.cancelAllAsyncTask();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAsyncTask() {
        try {
            StringBuffer address = new StringBuffer(30);
            address.append(Config.SERVER_ADDRESS);
            address.append(Config.PB_ADDRESS);
            ArrayList<BasicNameValuePair> param = new ArrayList<>();
            BasicNameValuePair theme = new BasicNameValuePair("kz", this.mTid);
            param.add(theme);
            BasicNameValuePair theme2 = new BasicNameValuePair(PARAM_PID, this.mPid);
            param.add(theme2);
            BasicNameValuePair theme3 = new BasicNameValuePair("mark", String.valueOf(1));
            param.add(theme3);
            BasicNameValuePair theme4 = new BasicNameValuePair("rn", String.valueOf(1));
            param.add(theme4);
            this.mTask = new PostAsyncTask(address.toString(), param);
            this.mTask.execute(address.toString(), param);
        } catch (Exception ex) {
            TiebaLog.e("PbActivity", "startPbAsyncTask", "error" + ex.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshActivity() {
        ArrayList<PostData> list;
        try {
            if (this.mModel != null && this.mModel.getData() != null && (list = this.mModel.getData().getPost_list()) != null && list.size() > 0) {
                PostData post = list.get(0);
                String floor = String.format(getString(R.string.post_x_floor), Integer.valueOf(post.getFloor_num()));
                this.mTitleText.setText(floor);
                this.mPhoto.setVisibility(0);
                String portrait = post.getAuthor().getPortrait();
                if (portrait != null && portrait.length() > 0) {
                    Bitmap bm = this.mImageLoader.getPhoto(portrait);
                    if (bm != null) {
                        this.mPhoto.setImageBitmap(bm);
                    } else {
                        this.mPhoto.setTag(portrait);
                        this.mPhoto.setImageResource(R.drawable.photo);
                    }
                } else {
                    this.mPhoto.setImageResource(R.drawable.photo);
                }
                if (post.getAuthor() != null && post.getAuthor().getName_show() != null) {
                    this.mUserName.setText(post.getAuthor().getName_show());
                } else {
                    this.mUserName.setText((CharSequence) null);
                }
                if (post.getAuthor() != null && post.getAuthor().getLevel_id() != 0) {
                    this.mRank.setText(String.valueOf(String.valueOf(post.getAuthor().getLevel_id())) + getString(R.string.grade));
                } else {
                    this.mRank.setText((CharSequence) null);
                }
                this.mTime.setText(StringHelper.getTimeString(post.getTime()));
                this.mFloorText.setVisibility(0);
                this.mFloorText.setText(String.valueOf(String.valueOf(post.getFloor_num())) + getString(R.string.floor));
                ArrayList<ContentData> content = post.getUnite_content();
                if (content != null && content.size() > 0) {
                    int i = 0;
                    ContentData seg = content.get(0);
                    if (seg != null && seg.getType() == 0) {
                        this.mText.setVisibility(0);
                        this.mText.setText(seg.getUniteString());
                        i = 0 + 1;
                    }
                    int index = -1;
                    this.mSeg.setVisibility(8);
                    while (i < content.size()) {
                        this.mSeg.setVisibility(0);
                        ContentData seg2 = content.get(i);
                        if (seg2.getType() == 3) {
                            if (this.mIsShowImages) {
                                index++;
                                ImageView imageView = new ImageView(this);
                                int height = UtilHelper.dip2px(this, 105.0f);
                                int width = UtilHelper.dip2px(this, 105.0f);
                                LinearLayout.LayoutParams imageViewparams = new LinearLayout.LayoutParams(-2, height);
                                int px_v = UtilHelper.dip2px(this, 15.0f);
                                imageViewparams.topMargin = px_v;
                                Bitmap image = this.mImageLoader.getPic(seg2.getLink());
                                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                imageView.setMaxWidth(width);
                                if (image != null) {
                                    imageView.setTag(null);
                                    imageView.setImageBitmap(image);
                                } else {
                                    imageView.setTag(seg2.getLink());
                                    imageView.setImageBitmap(BitmapHelper.getCashBitmap(R.drawable.image_default));
                                }
                                imageView.setClickable(true);
                                imageView.setFocusable(false);
                                ImageOnClickListener listern = new ImageOnClickListener(content, index);
                                imageView.setOnClickListener(listern);
                                this.mSeg.addView(imageView, imageViewparams);
                            }
                        } else {
                            CustomTextView textView = new CustomTextView(this);
                            LinearLayout.LayoutParams textViewparams = new LinearLayout.LayoutParams(-1, -2);
                            int px_v2 = UtilHelper.dip2px(this, 15.0f);
                            textViewparams.rightMargin = 0;
                            textViewparams.leftMargin = 0;
                            textViewparams.topMargin = px_v2;
                            textView.setTextSize(Config.getContentSize());
                            textView.setTextColor(-11974584);
                            textView.setText(seg2.getUniteString());
                            textView.setLineSpacing(0.0f, 1.2f);
                            textView.setMovementMethod(LinkMovementMethod.getInstance());
                            textView.setFocusable(false);
                            this.mSeg.addView(textView, textViewparams);
                        }
                        i++;
                    }
                } else {
                    this.mText.setVisibility(0);
                    this.mText.setText((CharSequence) null);
                }
                refreshPhoto();
            }
        } catch (Exception ex) {
            TiebaLog.e("PbActivity", "refreshActivity", "error = " + ex.getMessage());
        }
    }

    private void refreshPhoto() {
        try {
            ArrayList<PostData> list = this.mModel.getData().getPost_list();
            PostData data = list.get(0);
            if (data != null) {
                ArrayList<ContentData> content = data.getUnite_content();
                String authorPhoto = data.getAuthor().getPortrait();
                if (this.mModel.getIsDisplayPhoto() && authorPhoto != null && authorPhoto.length() > 0) {
                    this.mImageLoader.loadPbPhoto(authorPhoto, new AsyncImageLoader.ImageCallback() { // from class: com.baidu.tieba.mention.PostActivity.4
                        @Override // com.baidu.tieba.util.AsyncImageLoader.ImageCallback
                        public void imageLoaded(Bitmap bitmap, String imageUrl, boolean iscached) {
                            ImageView view = (ImageView) PostActivity.this.mPost.findViewWithTag(imageUrl);
                            while (view != null) {
                                view.setTag(null);
                                if (view != null && bitmap != null) {
                                    view.setImageBitmap(bitmap);
                                }
                                view = (ImageView) PostActivity.this.mPost.findViewWithTag(imageUrl);
                            }
                        }
                    });
                }
                int index = -1;
                int contentSize = content.size();
                if (this.mIsShowImages) {
                    for (int j = 0; j < contentSize; j++) {
                        if (content.get(j).getType() == 3) {
                            index++;
                            this.mImageLoader.loadImage(content.get(j).getLink(), new AsyncImageLoader.ImageCallback() { // from class: com.baidu.tieba.mention.PostActivity.5
                                @Override // com.baidu.tieba.util.AsyncImageLoader.ImageCallback
                                public void imageLoaded(Bitmap bitmap, String imageUrl, boolean iscached) {
                                    ImageView view = (ImageView) PostActivity.this.mPost.findViewWithTag(imageUrl);
                                    while (view != null) {
                                        view.setTag(null);
                                        if (view != null && bitmap != null) {
                                            view.setImageBitmap(bitmap);
                                        }
                                        view = (ImageView) PostActivity.this.mPost.findViewWithTag(imageUrl);
                                    }
                                }
                            });
                        }
                    }
                }
            }
        } catch (Exception ex) {
            TiebaLog.e("PbActivity", "mGetImageRunnble.run", "error = " + ex.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PostAsyncTask extends AsyncTask<Object, Integer, PbData> {
        private NetWork mNetwork = null;
        ArrayList<BasicNameValuePair> mParam;
        private String mUrl;

        public PostAsyncTask(String url, ArrayList<BasicNameValuePair> param) {
            this.mUrl = null;
            this.mParam = null;
            this.mUrl = url;
            this.mParam = param;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            PostActivity.this.mProgress.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public PbData doInBackground(Object... params) {
            PbData pbData = null;
            try {
                this.mNetwork = new NetWork(this.mUrl);
                this.mNetwork.setPostData(this.mParam);
                String data = this.mNetwork.postNetData();
                if (!this.mNetwork.isRequestSuccess()) {
                    return null;
                }
                PbData pbData2 = new PbData();
                try {
                    pbData2.parserJson(data);
                    int size = pbData2.getPost_list().size();
                    for (int i = 0; i < size; i++) {
                        pbData2.getPost_list().get(i).uniteContent(PostActivity.this);
                        pbData2.getPost_list().get(i).setContent(null);
                    }
                    return pbData2;
                } catch (Exception e) {
                    ex = e;
                    pbData = pbData2;
                    TiebaLog.e("PostAsyncTask", "doInBackground", "error = " + ex.getMessage());
                    return pbData;
                }
            } catch (Exception e2) {
                ex = e2;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(PbData data) {
            try {
                PostActivity.this.mProgress.setVisibility(8);
                if (data != null) {
                    PostActivity.this.mModel.setData(data);
                } else if (this.mNetwork != null) {
                    if (this.mNetwork.isNetSuccess()) {
                        PostActivity.this.showToast(this.mNetwork.getErrorString());
                        if (this.mNetwork.getErrorCode() == 4 || this.mNetwork.getErrorCode() == 28 || this.mNetwork.getErrorCode() == 29) {
                            PostActivity.this.finish();
                            return;
                        }
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(PostActivity.this);
                        builder.setTitle(PostActivity.this.getString(R.string.error));
                        builder.setMessage(this.mNetwork.getErrorString());
                        builder.setPositiveButton(PostActivity.this.getString(R.string.retry), new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.mention.PostActivity.PostAsyncTask.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                PostActivity.this.startAsyncTask();
                            }
                        });
                        builder.setNegativeButton(PostActivity.this.getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.baidu.tieba.mention.PostActivity.PostAsyncTask.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.create().show();
                    }
                }
                PostActivity.this.refreshActivity();
            } catch (Exception e) {
            }
            PostActivity.this.mTask = null;
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            super.onCancelled();
        }

        public void cancel() {
            if (this.mNetwork != null) {
                this.mNetwork.cancelNetConnect();
            }
            PostActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ImageOnClickListener implements View.OnClickListener {
        private ArrayList<ContentData> mContent;
        private int mIndex;

        public ImageOnClickListener(ArrayList<ContentData> content, int index) {
            this.mContent = content;
            this.mIndex = index;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            try {
                ArrayList<String> data = new ArrayList<>();
                for (int i = 0; i < this.mContent.size(); i++) {
                    if (this.mContent.get(i).getType() == 3) {
                        StringBuffer buffer = new StringBuffer(100);
                        buffer.append("size=");
                        buffer.append(Config.THREAD_IMAGE_MAX_WIDTH);
                        buffer.append("&src=");
                        String encode = StringHelper.getUrlEncode(this.mContent.get(i).getLink());
                        buffer.append(encode);
                        data.add(buffer.toString());
                    }
                }
                ImageActivity.startActivity(PostActivity.this, data, this.mIndex);
            } catch (Exception ex) {
                TiebaLog.e("PbAdapter", "ImageOnClickListener", "error = " + ex.getMessage());
            }
        }
    }
}
