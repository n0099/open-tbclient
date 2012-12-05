package com.baidu.tieba.write;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import cn.jingling.lib.filters.FilterFactory;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.PvThread;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.RequestResponseCode;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsImageActivity;
import com.baidu.tieba.pb.ImagePbActivity;
import com.baidu.tieba.service.TiebaPrepareImageService;
import com.baidu.tieba.util.BitmapHelper;
import com.baidu.tieba.util.FileHelper;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.util.TiebaLog;
import com.baidu.tieba.util.UtilHelper;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class WriteImageActivity extends BaseActivity {
    public static final String FILTER_NAME_NORMAL = "normal";
    public static final String FORUMID = "forumid";
    public static final String FORUMNAME = "foruimname";
    public static final String FROM = "from";
    public static final String FROMCODE = "request";
    public static final int PREVIEW_IMAGE_WIDTH = 300;
    public static final String THREADID = "threadid";
    private RadioButton mBtnBeautify;
    private RadioButton mBtnRotate;
    private LinearLayout mFilterView;
    private HashMap<String, Bitmap> previewBitmaps;
    private HashMap<String, ImageView> previewImageView;
    private int requestCode;
    public static String DELET_FLAG = "delete";
    public static String CHANGE_FLAG = "change";
    public static String FILE_NAME = "file_name";
    private static String[] filterNameArray = null;
    private ImageView mImage = null;
    private Bitmap mBitmap = null;
    private Button mBack = null;
    private Button mDelete = null;
    private LinearLayout mTitle = null;
    private HorizontalScrollView mBeautifyView = null;
    private ProgressBar mProgress = null;
    private GetImageTask mTask = null;
    private FilterTask mFilterTask = null;
    private LinearLayout mRotateView = null;
    private LinearLayout mBeautifyRotateView = null;
    private TextView mTitleText = null;
    private Bitmap mPreparedBitmap = null;
    private ImageResizedReceiver receiver = null;
    private int BOUND = 0;
    private int motuID = 0;
    private boolean isMotuOn = true;
    private String lastFilter = null;
    private boolean isEdited = false;
    private boolean isFromFrs = false;
    private View.OnClickListener backOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteImageActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (!WriteImageActivity.this.isFromFrs) {
                if (WriteImageActivity.this.requestCode == 1200003) {
                    Intent intent = new Intent();
                    if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                        if (WriteImageActivity.this.isEdited && WriteImageActivity.this.mPreparedBitmap != null && !WriteImageActivity.this.mPreparedBitmap.isRecycled()) {
                            Date data = new Date();
                            String filename = Config.TMPDIRNAME + String.valueOf(data.getTime()) + ".jpg";
                            if (WriteImageActivity.this.saveFile(filename)) {
                                intent.putExtra(WriteImageActivity.CHANGE_FLAG, true);
                                intent.putExtra(WriteImageActivity.FILE_NAME, filename);
                            } else {
                                intent.putExtra(WriteImageActivity.CHANGE_FLAG, false);
                            }
                        } else {
                            intent.putExtra(WriteImageActivity.CHANGE_FLAG, false);
                        }
                        WriteImageActivity.this.setResult(-1, intent);
                    } else {
                        return;
                    }
                } else {
                    WriteImageActivity.this.setResult(0, new Intent());
                }
            } else {
                WriteImageActivity.this.setResult(0, new Intent());
            }
            WriteImageActivity.this.finish();
        }
    };

    public static void startActivityForResult(Activity activity, Bitmap bm, int requestCode) {
        Intent intent = new Intent(activity, WriteImageActivity.class);
        if (bm != null) {
            intent.putExtra(FROMCODE, requestCode);
            activity.startActivityForResult(intent, RequestResponseCode.REQUEST_IMAGE_VIEW);
        }
    }

    public static void startActivityForResult(Activity activity, int fromCode, int requestCode, Uri uri, String forumId, String forumName, AntiData anti) {
        if (anti != null && anti.getIfpost() == 0) {
            UtilHelper.showToast(activity, anti.getForbid_info());
            return;
        }
        Intent intent = new Intent(activity, WriteImageActivity.class);
        intent.putExtra(FROMCODE, fromCode);
        if ((activity instanceof FrsActivity) || (activity instanceof ImagePbActivity) || (activity instanceof FrsImageActivity)) {
            intent.putExtra(FROM, "frs");
        }
        intent.putExtra(FORUMID, forumId);
        intent.putExtra(FORUMNAME, forumName);
        intent.setData(uri);
        activity.startActivityForResult(intent, requestCode);
    }

    public static void startActivityForResult(Activity activity, int fromCode, int requestCode, Uri uri, String forumId, String forumName, String ThreadID, AntiData anti) {
        if (anti != null && anti.getIfpost() == 0) {
            UtilHelper.showToast(activity, anti.getForbid_info());
            return;
        }
        Intent intent = new Intent(activity, WriteImageActivity.class);
        intent.putExtra(FROMCODE, fromCode);
        if ((activity instanceof FrsActivity) || (activity instanceof ImagePbActivity) || (activity instanceof FrsImageActivity)) {
            intent.putExtra(FROM, "frs");
        }
        intent.putExtra(FORUMID, forumId);
        intent.putExtra(FORUMNAME, forumName);
        intent.putExtra(THREADID, ThreadID);
        intent.setData(uri);
        activity.startActivityForResult(intent, requestCode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TiebaApplication.app.addRemoteActivity(this);
        setContentView(R.layout.write_image_activity);
        Intent intent = getIntent();
        this.requestCode = intent.getIntExtra(FROMCODE, 0);
        if (intent.getStringExtra(FROM) != null && intent.getStringExtra(FROM).equals("frs")) {
            this.isFromFrs = true;
        }
        if (this.requestCode == 1200002 || this.requestCode == 1200001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.requestCode, intent.getData(), TiebaApplication.app.getPostImageSize());
            } else {
                TiebaPrepareImageService.StartService(this.requestCode, null, TiebaApplication.app.getPostImageSize());
            }
            regReceiver();
        } else {
            initUI();
            initData();
        }
        filterNameArray = getResources().getStringArray(R.array.fiter_name);
        this.isMotuOn = TiebaApplication.app.getIsMotuOn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Drawable dr = this.mImage.getDrawable();
        if (dr != null && (dr instanceof BitmapDrawable) && ((BitmapDrawable) dr).getBitmap() == null && this.mTask == null) {
            this.mTask = new GetImageTask(this, null);
            this.mTask.execute(new Object[0]);
        }
    }

    @Override // com.baidu.tieba.BaseActivity
    public void releaseResouce() {
        if (this.mTask != null) {
            this.mTask.cancel();
        }
        this.mImage.setImageBitmap(null);
        releasePreviewResouce();
    }

    private void releasePreviewResouce() {
        if (this.previewImageView != null) {
            for (Map.Entry<String, ImageView> tempEntry : this.previewImageView.entrySet()) {
                ImageView tempBitmap = tempEntry.getValue();
                if (tempBitmap != null) {
                    tempBitmap.setImageBitmap(null);
                }
            }
            this.previewImageView.clear();
            this.previewImageView = null;
        }
        if (this.previewBitmaps != null) {
            for (Map.Entry<String, Bitmap> tempEntry2 : this.previewBitmaps.entrySet()) {
                Bitmap tempBitmap2 = tempEntry2.getValue();
                if (tempBitmap2 != null && !tempBitmap2.isRecycled()) {
                    tempBitmap2.recycle();
                }
            }
            this.previewBitmaps.clear();
            this.previewBitmaps = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.mTask != null) {
            this.mTask.cancel();
        }
        this.mTask = new GetImageTask(this, null);
        this.mTask.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.mPreparedBitmap != null && !this.mPreparedBitmap.isRecycled()) {
            this.mPreparedBitmap.recycle();
            this.mPreparedBitmap = null;
        }
        if (this.mTask != null) {
            this.mTask.cancel();
            this.mTask = null;
        }
        this.mProgress.setVisibility(8);
        if (this.requestCode == 1200002 || this.requestCode == 1200001) {
            unregisterReceiver(this.receiver);
        }
        TiebaApplication.app.delRemoteActivity(this);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            this.backOnClickListener.onClick(null);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void initUI() {
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        this.mProgress.setVisibility(8);
        this.mImage = (ImageView) findViewById(R.id.image);
        this.mImage.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteImageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (WriteImageActivity.this.mTitle.getVisibility() == 0) {
                    WriteImageActivity.this.mTitle.setVisibility(8);
                    WriteImageActivity.this.mBeautifyRotateView.setVisibility(8);
                    return;
                }
                WriteImageActivity.this.mTitle.setVisibility(0);
                WriteImageActivity.this.mBeautifyRotateView.setVisibility(0);
            }
        });
        this.mImage.setImageBitmap(this.mBitmap);
        this.mTitle = (LinearLayout) findViewById(R.id.title);
        this.mBeautifyView = (HorizontalScrollView) findViewById(R.id.filters_layout);
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteImageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (!WriteImageActivity.this.isFromFrs) {
                    if (WriteImageActivity.this.requestCode == 1200003) {
                        Intent intent = new Intent();
                        if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                            if (WriteImageActivity.this.isEdited && WriteImageActivity.this.mPreparedBitmap != null && !WriteImageActivity.this.mPreparedBitmap.isRecycled()) {
                                Date data = new Date();
                                String filename = Config.TMPDIRNAME + String.valueOf(data.getTime()) + ".jpg";
                                if (WriteImageActivity.this.saveFile(filename)) {
                                    intent.putExtra(WriteImageActivity.CHANGE_FLAG, true);
                                    intent.putExtra(WriteImageActivity.FILE_NAME, filename);
                                } else {
                                    intent.putExtra(WriteImageActivity.CHANGE_FLAG, false);
                                }
                            } else {
                                intent.putExtra(WriteImageActivity.CHANGE_FLAG, false);
                            }
                            WriteImageActivity.this.setResult(-1, intent);
                        } else {
                            return;
                        }
                    } else {
                        WriteImageActivity.this.setResult(0, new Intent());
                    }
                } else {
                    WriteImageActivity.this.setResult(0, new Intent());
                }
                WriteImageActivity.this.finish();
            }
        });
        this.mDelete = (Button) findViewById(R.id.delete);
        if (this.isFromFrs || this.requestCode != 1200003) {
            this.mDelete.setText(getString(R.string.done));
        }
        this.mDelete.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteImageActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (WriteImageActivity.this.isFromFrs) {
                    if (WriteImageActivity.this.isEdited) {
                        if (WriteImageActivity.this.mPreparedBitmap != null && !WriteImageActivity.this.mPreparedBitmap.isRecycled()) {
                            Date data = new Date();
                            String filename = Config.TMPDIRNAME + String.valueOf(data.getTime()) + ".jpg";
                            if (WriteImageActivity.this.saveFile(filename)) {
                                Intent intent = WriteImageActivity.this.getIntent();
                                if (intent.getStringExtra(WriteImageActivity.THREADID) == null) {
                                    WriteActivity.startAcitivityForResult(WriteImageActivity.this, intent.getStringExtra(WriteImageActivity.FORUMID), intent.getStringExtra(WriteImageActivity.FORUMNAME), null, true, filename);
                                } else {
                                    WriteActivity.startAcitivityForResult(WriteImageActivity.this, intent.getStringExtra(WriteImageActivity.FORUMID), intent.getStringExtra(WriteImageActivity.FORUMNAME), intent.getStringExtra(WriteImageActivity.THREADID), filename);
                                }
                            }
                        }
                    } else {
                        Intent intent2 = WriteImageActivity.this.getIntent();
                        if (intent2.getStringExtra(WriteImageActivity.THREADID) == null) {
                            WriteActivity.startAcitivityForResult(WriteImageActivity.this, intent2.getStringExtra(WriteImageActivity.FORUMID), intent2.getStringExtra(WriteImageActivity.FORUMNAME), null, true, null);
                        } else {
                            WriteActivity.startAcitivityForResult(WriteImageActivity.this, intent2.getStringExtra(WriteImageActivity.FORUMID), intent2.getStringExtra(WriteImageActivity.FORUMNAME), intent2.getStringExtra(WriteImageActivity.THREADID), null);
                        }
                    }
                    WriteImageActivity.this.setResult(-1, new Intent());
                } else if (WriteImageActivity.this.requestCode == 1200003) {
                    Intent intent3 = new Intent();
                    intent3.putExtra(WriteImageActivity.DELET_FLAG, true);
                    WriteImageActivity.this.setResult(-1, intent3);
                } else {
                    Intent intent4 = new Intent();
                    if (WriteImageActivity.this.isEdited) {
                        if (WriteImageActivity.this.mPreparedBitmap != null && !WriteImageActivity.this.mPreparedBitmap.isRecycled()) {
                            Date data2 = new Date();
                            String filename2 = Config.TMPDIRNAME + String.valueOf(data2.getTime()) + ".jpg";
                            if (WriteImageActivity.this.saveFile(filename2)) {
                                intent4.putExtra(WriteImageActivity.CHANGE_FLAG, true);
                                intent4.putExtra(WriteImageActivity.FILE_NAME, filename2);
                            } else {
                                intent4.putExtra(WriteImageActivity.CHANGE_FLAG, false);
                            }
                        } else {
                            intent4.putExtra(WriteImageActivity.CHANGE_FLAG, false);
                        }
                    } else {
                        intent4.setData(WriteImageActivity.this.getIntent().getData());
                        WriteImageActivity.this.setResult(-1, intent4);
                    }
                    WriteImageActivity.this.setResult(-1, intent4);
                }
                WriteImageActivity.this.finish();
            }
        });
        this.mFilterView = (LinearLayout) findViewById(R.id.filters);
        this.BOUND = UtilHelper.dip2px(this, 2.0f);
        if (Build.VERSION.SDK_INT < 7 || !this.isMotuOn) {
            this.mBeautifyRotateView.setVisibility(8);
        }
        this.mTitleText = (TextView) findViewById(R.id.editimage_title);
        this.mBeautifyRotateView = (LinearLayout) findViewById(R.id.beautify_rotate);
        this.mRotateView = (LinearLayout) findViewById(R.id.rotate);
        this.mBtnBeautify = (RadioButton) findViewById(R.id.beautify_btn);
        this.mBtnRotate = (RadioButton) findViewById(R.id.rotate_btn);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.write.WriteImageActivity.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    buttonView.setTextColor(WriteImageActivity.this.getResources().getColor(R.color.white));
                    if (buttonView == WriteImageActivity.this.mBtnBeautify) {
                        WriteImageActivity.this.mBeautifyView.setVisibility(0);
                        WriteImageActivity.this.mRotateView.setVisibility(4);
                        WriteImageActivity.this.mTitleText.setText(WriteImageActivity.this.getString(R.string.beautify));
                        return;
                    } else if (buttonView == WriteImageActivity.this.mBtnRotate) {
                        WriteImageActivity.this.mBeautifyView.setVisibility(4);
                        WriteImageActivity.this.mRotateView.setVisibility(0);
                        WriteImageActivity.this.mTitleText.setText(WriteImageActivity.this.getString(R.string.rotate));
                        return;
                    } else {
                        return;
                    }
                }
                buttonView.setTextColor(WriteImageActivity.this.getResources().getColor(R.color.beautify_rotate_tab_unchecked_color));
            }
        };
        this.mBtnBeautify.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mBtnRotate.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mBtnBeautify.setChecked(true);
        Button rotateLeft = (Button) findViewById(R.id.rotate_left);
        Button rotateRight = (Button) findViewById(R.id.rotate_right);
        Button rotateLeftRight = (Button) findViewById(R.id.rotate_left_right);
        Button rotateUpDown = (Button) findViewById(R.id.rotate_up_down);
        rotateLeft.setTag(0);
        rotateRight.setTag(1);
        rotateLeftRight.setTag(2);
        rotateUpDown.setTag(3);
        View.OnClickListener rotateClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteImageActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (WriteImageActivity.this.mProgress.getVisibility() != 0 && v.getTag() != null) {
                    WriteImageActivity.this.isEdited = false;
                    WriteImageActivity.this.startFilterTask(v.getTag().toString());
                }
            }
        };
        rotateLeft.setOnClickListener(rotateClickListener);
        rotateRight.setOnClickListener(rotateClickListener);
        rotateLeftRight.setOnClickListener(rotateClickListener);
        rotateUpDown.setOnClickListener(rotateClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFilterTask(String label) {
        if (this.mFilterTask != null) {
            this.mFilterTask.cancel();
        }
        this.mFilterTask = new FilterTask(this, null);
        this.mFilterTask.execute(label);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class GetImageTask extends AsyncTask<Object, Integer, Bitmap> {
        private GetImageTask() {
        }

        /* synthetic */ GetImageTask(WriteImageActivity writeImageActivity, GetImageTask getImageTask) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Object... params) {
            String[] strArr;
            try {
                Bitmap bitmap = FileHelper.getImage(null, Config.IMAGE_RESIZED_FILE);
                if (isCancelled() && bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                    return null;
                }
                int bitmapWidth = UtilHelper.dip2px(WriteImageActivity.this, 63.5f);
                if (Build.VERSION.SDK_INT >= 7 && WriteImageActivity.this.isMotuOn) {
                    Bitmap smallBitmap = BitmapHelper.getRoundedCornerBitmap(BitmapHelper.getResizedBitmap(bitmap, bitmapWidth), UtilHelper.dip2px(WriteImageActivity.this, 5.0f));
                    WriteImageActivity.this.previewBitmaps = new HashMap();
                    WriteImageActivity.this.previewImageView = new HashMap();
                    WriteImageActivity.this.previewBitmaps.put(WriteImageActivity.FILTER_NAME_NORMAL, smallBitmap);
                    for (String label : WriteImageActivity.filterNameArray) {
                        String filter = label.substring(0, label.indexOf("|"));
                        if (!filter.equals(WriteImageActivity.FILTER_NAME_NORMAL)) {
                            Bitmap preview = FilterFactory.createOneKeyFilter(WriteImageActivity.this, filter).apply(WriteImageActivity.this, smallBitmap.copy(smallBitmap.getConfig(), true));
                            WriteImageActivity.this.previewBitmaps.put(filter, preview);
                        }
                    }
                    return bitmap;
                }
                return bitmap;
            } catch (Exception e) {
                TiebaLog.e(getClass().getName(), "GetImageTask", e.toString());
                return null;
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            WriteImageActivity.this.mProgress.setVisibility(0);
            super.onPreExecute();
        }

        public void cancel() {
            WriteImageActivity.this.mTask = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap result) {
            super.onPostExecute((GetImageTask) result);
            WriteImageActivity.this.mTask = null;
            WriteImageActivity.this.mBitmap = result;
            WriteImageActivity.this.mProgress.setVisibility(8);
            if (result != null && !result.isRecycled() && result != null) {
                WriteImageActivity.this.mImage.setImageBitmap(result);
                if (Build.VERSION.SDK_INT < 7 || !WriteImageActivity.this.isMotuOn) {
                    return;
                }
                WriteImageActivity.this.makeFilters(WriteImageActivity.filterNameArray);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean saveFile(String filename) {
        try {
            FileHelper.SaveFile(Config.LOCAL_PIC_DIR, filename, this.mPreparedBitmap, 90);
            Bitmap display = BitmapHelper.getResizedBitmap(this.mPreparedBitmap, 100);
            if (display != null && FileHelper.SaveFile(null, Config.IMAGE_RESIZED_FILE_DISPLAY, display, 80) != null) {
                new PvThread("motu_pic", String.valueOf(this.motuID)).start();
                return true;
            }
        } catch (Exception e) {
            TiebaLog.e(getClass().getName(), "saveFile", e.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeFilters(String[] labels) {
        if (this.previewBitmaps != null && labels != null) {
            this.mFilterView.removeAllViews();
            this.mBeautifyRotateView.setVisibility(0);
            View filterItem = getLayoutInflater().inflate(R.layout.filter_item, (ViewGroup) null);
            ImageView imageView = (ImageView) filterItem.findViewById(R.id.filter_immage);
            TextView textView = (TextView) filterItem.findViewById(R.id.filter_text);
            int length = labels.length;
            int i = 0;
            int count = 0;
            while (i < length) {
                String label = labels[i];
                final String filter = label.substring(0, label.indexOf("|"));
                String name = label.substring(label.indexOf("|") + 1);
                View filterItem2 = getLayoutInflater().inflate(R.layout.filter_item, (ViewGroup) null);
                ImageView previewView = (ImageView) filterItem2.findViewById(R.id.filter_immage);
                TextView previewText = (TextView) filterItem2.findViewById(R.id.filter_text);
                previewText.setText(name);
                previewView.setImageBitmap(this.previewBitmaps.get(filter));
                int count2 = count + 1;
                final int id = count;
                if (filter.equals(FILTER_NAME_NORMAL)) {
                    previewView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteImageActivity.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            if (WriteImageActivity.this.mProgress.getVisibility() != 0) {
                                WriteImageActivity.this.mImage.setImageBitmap(WriteImageActivity.this.mBitmap);
                                WriteImageActivity.this.isEdited = false;
                                WriteImageActivity.this.setChecked(filter);
                                WriteImageActivity.this.motuID = id;
                            }
                        }
                    });
                } else {
                    previewView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.WriteImageActivity.8
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            if (WriteImageActivity.this.mProgress.getVisibility() != 0 && !filter.equals(WriteImageActivity.this.lastFilter)) {
                                WriteImageActivity.this.startFilterTask(filter);
                                WriteImageActivity.this.setChecked(filter);
                                WriteImageActivity.this.motuID = id;
                            }
                        }
                    });
                }
                this.mFilterView.addView(filterItem2);
                this.previewImageView.put(filter, previewView);
                i++;
                count = count2;
            }
            setChecked(FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChecked(String filtername) {
        ImageView lastView;
        if (filtername != null) {
            if (this.lastFilter != null && (lastView = this.previewImageView.get(this.lastFilter)) != null) {
                lastView.setBackgroundDrawable(null);
                lastView.setPadding(this.BOUND, this.BOUND, this.BOUND, this.BOUND);
            }
            ImageView newView = this.previewImageView.get(filtername);
            if (newView != null) {
                newView.setBackgroundResource(R.drawable.round_corner);
                newView.setPadding(this.BOUND, this.BOUND, this.BOUND, this.BOUND);
            }
            this.lastFilter = filtername;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class FilterTask extends AsyncTask<String, Void, Bitmap> {
        private Bitmap bitmap;
        private Boolean isRecyle;
        private Boolean isRotate;
        private String mLabel;

        private FilterTask() {
            this.isRotate = false;
            this.isRecyle = false;
        }

        /* synthetic */ FilterTask(WriteImageActivity writeImageActivity, FilterTask filterTask) {
            this();
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            WriteImageActivity.this.mProgress.setVisibility(0);
            WriteImageActivity.this.mDelete.setClickable(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String... arg0) {
            this.mLabel = arg0[0];
            if (this.mLabel.equals("0") || this.mLabel.equals(NetWorkCore.NET_TYPE_NET)) {
                this.isRotate = true;
            } else if (this.mLabel.equals(NetWorkCore.NET_TYPE_WAP) || this.mLabel.equals(NetWorkCore.NET_TYPE_WIFI)) {
                this.isRecyle = true;
            }
            if (!this.isRotate.booleanValue() && !this.isRecyle.booleanValue()) {
                this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
            } else if (WriteImageActivity.this.mPreparedBitmap == null) {
                this.bitmap = WriteImageActivity.this.mBitmap.copy(WriteImageActivity.this.mBitmap.getConfig(), true);
            } else {
                this.bitmap = WriteImageActivity.this.mPreparedBitmap.copy(WriteImageActivity.this.mPreparedBitmap.getConfig(), true);
            }
            if (this.bitmap.getWidth() > 600 || this.bitmap.getHeight() > 600) {
                this.bitmap = BitmapHelper.resizeBitmap(this.bitmap, 600);
            }
            if (this.isRotate.booleanValue()) {
                this.bitmap = BitmapHelper.rotateBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else if (this.isRecyle.booleanValue()) {
                this.bitmap = BitmapHelper.reversalBitmap(this.bitmap, Integer.parseInt(this.mLabel));
            } else {
                this.bitmap = FilterFactory.createOneKeyFilter(WriteImageActivity.this, this.mLabel).apply(WriteImageActivity.this, this.bitmap);
            }
            return this.bitmap;
        }

        public void cancel() {
            if (this.bitmap != null && !this.bitmap.isRecycled() && WriteImageActivity.this.mPreparedBitmap != this.bitmap) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.mDelete.setClickable(true);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bm) {
            WriteImageActivity.this.mProgress.setVisibility(8);
            WriteImageActivity.this.mDelete.setClickable(true);
            if (bm != null && !bm.isRecycled()) {
                WriteImageActivity.this.isEdited = true;
                WriteImageActivity.this.mImage.setImageBitmap(bm);
                if (this.isRotate.booleanValue() || this.isRecyle.booleanValue()) {
                    if (WriteImageActivity.this.mBitmap.getWidth() > 600 || WriteImageActivity.this.mBitmap.getHeight() > 600) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.resizeBitmap(WriteImageActivity.this.mBitmap, 600);
                    }
                    if (this.isRotate.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.rotateBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    } else if (this.isRecyle.booleanValue()) {
                        WriteImageActivity.this.mBitmap = BitmapHelper.reversalBitmap(WriteImageActivity.this.mBitmap, Integer.parseInt(this.mLabel));
                    }
                }
                if (WriteImageActivity.this.mPreparedBitmap != null && !WriteImageActivity.this.mPreparedBitmap.isRecycled()) {
                    WriteImageActivity.this.mPreparedBitmap.recycle();
                }
                WriteImageActivity.this.mPreparedBitmap = bm;
            }
        }
    }

    private void regReceiver() {
        this.receiver = new ImageResizedReceiver(this, null);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Config.BROADCAST_IMAGE_RESIZED);
        registerReceiver(this.receiver, filter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ImageResizedReceiver extends BroadcastReceiver {
        private ImageResizedReceiver() {
        }

        /* synthetic */ ImageResizedReceiver(WriteImageActivity writeImageActivity, ImageResizedReceiver imageResizedReceiver) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            WriteImageActivity.this.releaseResouce();
            if (intent.getBooleanExtra("result", false)) {
                WriteImageActivity.this.initData();
            } else {
                WriteImageActivity.this.showToast(intent.getStringExtra("error"));
            }
        }
    }
}
