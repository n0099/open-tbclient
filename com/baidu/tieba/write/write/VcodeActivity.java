package com.baidu.tieba.write.write;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VcodeActivity extends BaseActivity<VcodeActivity> {
    private WriteData dPP = null;
    private TextView dNs = null;
    private ImageView aGW = null;
    private EditText mEdit = null;
    private ProgressBar mProgressBar = null;
    private b dQe = null;
    private a dQf = null;
    private InputMethodManager mInputManager = null;
    private DialogInterface.OnCancelListener cKN = null;
    private RelativeLayout bGY = null;
    private TextView aUE = null;
    protected NavigationBar mNavigationBar = null;
    private final View.OnClickListener dQa = new u(this);
    private final View.OnClickListener dQb = new v(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.vcode_activity);
        initUI();
        initData(bundle);
        nw(this.dPP.getVcodeUrl());
    }

    private void initData(Bundle bundle) {
        this.cKN = new w(this);
        if (bundle != null) {
            this.dPP = (WriteData) bundle.getSerializable("model");
        } else {
            this.dPP = (WriteData) getIntent().getSerializableExtra("model");
        }
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dPP != null && this.dPP.getType() == 3) {
            if (this.dQe != null) {
                this.dQe.cancel();
            }
            if (this.dQf != null) {
                this.dQf.cancel();
            }
            if (this.mProgressBar != null) {
                this.mProgressBar.setVisibility(8);
            }
            com.baidu.tbadk.core.c.b.b(getPageContext().getPageActivity(), 200, false);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dQe != null) {
            this.dQe.cancel();
        }
        if (this.dQf != null) {
            this.dQf.cancel();
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.dPP);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        int i2;
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.as.e(this.bGY, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.as.i((View) this.dNs, n.e.s_navbar_button_bg);
        if (i == 1) {
            i2 = com.baidu.tbadk.core.util.as.cB(i);
        } else {
            i2 = -12895429;
        }
        this.aUE.setTextColor(i2);
    }

    private void initUI() {
        this.bGY = (RelativeLayout) findViewById(n.f.parent);
        this.mNavigationBar = (NavigationBar) findViewById(n.f.view_navigation_bar);
        this.aUE = (TextView) findViewById(n.f.info);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dQa);
        this.dNs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(n.i.send), this.dQb);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dNs.getLayoutParams();
        layoutParams.rightMargin = com.baidu.adp.lib.util.k.d(getPageContext().getPageActivity(), n.d.ds16);
        this.dNs.setLayoutParams(layoutParams);
        this.mEdit = (EditText) findViewById(n.f.input);
        this.aGW = (ImageView) findViewById(n.f.vcode_image);
        this.aGW.setImageDrawable(null);
        this.aGW.setOnClickListener(new x(this));
        this.mProgressBar = (ProgressBar) findViewById(n.f.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nw(String str) {
        if (this.dQf != null) {
            this.dQf.cancel();
        }
        this.mProgressBar.setVisibility(0);
        this.aGW.setImageDrawable(null);
        this.dQf = new a(this, null);
        this.dQf.setPriority(3);
        this.dQf.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.n> {
        private com.baidu.tbadk.core.util.ab agS = null;
        private String dCh = null;
        private WriteData dQi;

        public b(WriteData writeData) {
            this.dQi = null;
            this.dQi = writeData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public com.baidu.tbadk.coreExtra.data.n doInBackground(Integer... numArr) {
            String str;
            Address y;
            if (this.dQi != null) {
                this.agS = new com.baidu.tbadk.core.util.ab();
                String editable = VcodeActivity.this.mEdit.getText().toString();
                String imagesCodeForPost = this.dQi.getImagesCodeForPost();
                if (this.dQi.getType() == 3) {
                    this.agS.o("newVcode", "1");
                    this.agS.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.dQi.getContent()) + imagesCodeForPost);
                    this.agS.o(PayVcodeActivityConfig.VCODE_MD5, this.dQi.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.agS.o("vcode", editable);
                    }
                    this.agS.o("tag", "11");
                    this.agS.uM().vF().mIsNeedTbs = true;
                    this.agS.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.dQi.getContent()) + imagesCodeForPost);
                    this.agS.setUrl(com.baidu.tieba.tbadkCore.c.a.dAd);
                    this.agS.o(ImageViewerConfig.FORUM_NAME, this.dQi.getForumName());
                    this.agS.o("title", this.dQi.getTitle());
                    this.agS.o("apiKey", this.dQi.getShareApiKey());
                    this.agS.o("appName", this.dQi.getShareAppName());
                    this.agS.o("signKey", this.dQi.getShareSignKey());
                    this.agS.o("summary_title", this.dQi.getShareSummaryTitle());
                    this.agS.o("summary_content", this.dQi.getShareSummaryContent());
                    this.agS.o("summary_img", this.dQi.getShareSummaryImg());
                    this.agS.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.dQi.getShareSummaryImgWidth()));
                    this.agS.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.dQi.getShareSummaryImgHeight()));
                    this.agS.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.dQi.getShareSummaryImgType());
                    this.agS.o("referUrl", this.dQi.getShareReferUrl());
                } else {
                    this.agS.o("anonymous", "0");
                    this.agS.o(ImageViewerConfig.FORUM_ID, this.dQi.getForumId());
                    this.agS.o("kw", this.dQi.getForumName());
                    this.agS.o("new_vcode", "1");
                    VideoInfo videoInfo = this.dQi.getVideoInfo();
                    if (videoInfo == null || !videoInfo.hasUpload()) {
                        str = String.valueOf(this.dQi.getContent()) + imagesCodeForPost;
                    } else {
                        str = String.valueOf(this.dQi.getContent()) + videoInfo.buildContent() + imagesCodeForPost;
                    }
                    if (this.dQi.getType() == 6 && this.dQi.getVoteInfo() != null) {
                        if (this.dQi.getWriteImagesInfo() != null) {
                            this.dQi.getVoteInfo().setServerImageCode(this.dQi.getWriteImagesInfo().getChosedFiles());
                        }
                        str = this.dQi.getVoteInfo().buildWriteContent();
                    }
                    this.agS.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                    if (this.dQi.getIsBaobaoImageUploaded()) {
                        this.agS.o("tail_type", String.valueOf(a.C0085a.dAh));
                        this.agS.o("tail_content", this.dQi.getBaobaoContent());
                        this.dQi.setBabaoPosted(true);
                    } else {
                        this.dQi.setBabaoPosted(false);
                    }
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.agS, this.dQi);
                    this.agS.o("vcode_md5", this.dQi.getVcodeMD5());
                    if (editable.length() > 0) {
                        this.agS.o("vcode", editable);
                    }
                    this.agS.uM().vF().mIsNeedTbs = true;
                    if (this.dQi.getVoice() != null) {
                        this.agS.o("voice_md5", this.dQi.getVoice());
                        this.agS.o("during_time", String.valueOf(this.dQi.getVoiceDuringTime()));
                    }
                    if (this.dQi.getType() == 0) {
                        this.agS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.agS.o("title", this.dQi.getTitle());
                        this.agS.o("is_ntitle", this.dQi.isNoTitle() ? "1" : "0");
                        if (this.dQi.getCategoryFrom() >= 0) {
                            this.agS.o("fromCategoryId", String.valueOf(this.dQi.getCategoryFrom()));
                        }
                        if (this.dQi.getCategoryTo() >= 0) {
                            this.agS.o("toCategoryId", String.valueOf(this.dQi.getCategoryTo()));
                        }
                        if (this.dQi.getLiveCardData() != null) {
                            this.agS.o("group_id", String.valueOf(this.dQi.getLiveCardData().getGroupId()));
                            this.agS.o("start_time", String.valueOf(this.dQi.getLiveCardData().getStartTime()));
                        }
                        if (!TbConfig.getPositionPagerId().equals(VcodeActivity.this.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (y = com.baidu.adp.lib.e.a.gD().y(false)) != null) {
                            this.agS.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                        }
                    } else if (this.dQi.getType() == 6) {
                        this.agS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.agS.o("title", this.dQi.getTitle());
                        this.agS.o("is_ntitle", this.dQi.isNoTitle() ? "1" : "0");
                        this.agS.o("thread_type", String.valueOf(36));
                    } else if (this.dQi.getType() == 4) {
                        this.agS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                        this.agS.o("title", this.dQi.getTitle());
                        this.agS.o("is_ntitle", "0");
                        this.agS.o("thread_type", String.valueOf(33));
                        this.agS.o("is_twzhibo_thread", String.valueOf(1));
                    } else {
                        this.agS.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                        this.agS.o("tid", this.dQi.getThreadId());
                        this.agS.o("is_ad", VcodeActivity.this.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                        if (this.dQi.getType() == 2) {
                            this.agS.o("quote_id", String.valueOf(this.dQi.getFloor()));
                            this.agS.o("floor_num", String.valueOf(this.dQi.getFloorNum()));
                            this.agS.o(WriteActivityConfig.IS_ADDITION, this.dQi.isAddition() ? "1" : "0");
                            if (this.dQi.getRepostId() != null) {
                                this.agS.o("repostid", this.dQi.getRepostId());
                            }
                        } else if (this.dQi.getType() == 5) {
                            this.agS.o("is_twzhibo_thread", String.valueOf(1));
                        } else if (this.dQi.getType() == 1 && com.baidu.tbadk.editortools.d.b.BV().getStatus() == 1) {
                            this.agS.o("ptype", "4");
                        }
                    }
                }
                this.dCh = this.agS.ul();
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.dQe = null;
            VcodeActivity.this.closeLoadingDialog();
            if (this.agS != null) {
                this.agS.gL();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00be  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(com.baidu.tbadk.coreExtra.data.n nVar) {
            String str;
            String str2;
            JSONException e;
            VcodeActivity.this.closeLoadingDialog();
            VcodeActivity.this.dQe = null;
            if (this.agS != null) {
                if (this.agS.uM().vG().rf()) {
                    ErrorData errorData = new ErrorData();
                    errorData.parserJson(this.dCh);
                    if (errorData.error_code == 0) {
                        try {
                            str = new JSONObject(this.dCh).optString(AddFriendActivityConfig.MSG);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            str = null;
                        }
                        if (StringUtils.isNull(str)) {
                            str = TbadkCoreApplication.m411getInst().getString(n.i.send_success);
                        }
                        if (this.dQi.getType() != 3) {
                            com.baidu.tieba.tbadkCore.writeModel.e.R(VcodeActivity.this.getPageContext().getPageActivity(), str);
                        }
                        this.dQi.deleteUploadedTempImages();
                        if (this.dQi != null && this.dQi.isBabaoPosted()) {
                            com.baidu.tieba.tbadkCore.PbEditor.a.aCz();
                        }
                    } else if ((this.dQi.isHasImages() || this.dQi.getIsBaobao()) && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.dQi.getContent()) + this.dQi.getImagesCodeForPost())) {
                        VcodeActivity.this.showToast(TbadkCoreApplication.m411getInst().getString(n.i.img_upload_error));
                    } else if (this.dQi.getType() != 3) {
                        VcodeActivity.this.showToast(errorData.getError_msg());
                    }
                    PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(0, null, null, null);
                    String str3 = "";
                    try {
                        str2 = new JSONObject(this.dCh).optString("tid");
                        try {
                            str3 = new JSONObject(this.dCh).optString(Info.kBaiduPIDKey);
                        } catch (JSONException e3) {
                            e = e3;
                            e.printStackTrace();
                            postWriteCallBackData.setThreadId(str2);
                            postWriteCallBackData.setPostId(str3);
                            Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                            intent.putExtras(bundle);
                            VcodeActivity.this.setResult(-1, intent);
                            if (this.dQi.getLiveCardData() != null) {
                            }
                            VcodeActivity.this.finish();
                            super.onPostExecute(nVar);
                        }
                    } catch (JSONException e4) {
                        str2 = "";
                        e = e4;
                    }
                    postWriteCallBackData.setThreadId(str2);
                    postWriteCallBackData.setPostId(str3);
                    Intent intent2 = new Intent();
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                    intent2.putExtras(bundle2);
                    VcodeActivity.this.setResult(-1, intent2);
                    if (this.dQi.getLiveCardData() != null) {
                        VcodeActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_REFRESH, new FrsActivityConfig(VcodeActivity.this.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.dQi.getForumName(), "post live's thread")));
                    }
                    VcodeActivity.this.finish();
                } else if (this.dQi.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(String.valueOf(this.dQi.getContent()) + this.dQi.getImagesCodeForPost())) {
                    VcodeActivity.this.showToast(TbadkCoreApplication.m411getInst().getString(n.i.img_upload_error));
                } else {
                    if (this.agS.uQ() == 5 || this.agS.uQ() == 6) {
                        com.baidu.tbadk.coreExtra.data.n nVar2 = new com.baidu.tbadk.coreExtra.data.n();
                        nVar2.parserJson(this.dCh);
                        if (nVar2.getVcode_pic_url() != null) {
                            VcodeActivity.this.dPP.setVcodeMD5(nVar2.getVcode_md5());
                            VcodeActivity.this.dPP.setVcodeUrl(nVar2.getVcode_pic_url());
                            VcodeActivity.this.nw(VcodeActivity.this.dPP.getVcodeUrl());
                        }
                        VcodeActivity.this.mEdit.setText((CharSequence) null);
                    }
                    VcodeActivity.this.showToast(this.agS.getErrorString());
                }
            }
            super.onPostExecute(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Bitmap> {
        volatile com.baidu.tbadk.core.util.ab Ty;
        private volatile boolean aTV;
        com.baidu.tbadk.coreExtra.data.n dQh;

        private a() {
            this.Ty = null;
            this.dQh = null;
            this.aTV = false;
        }

        /* synthetic */ a(VcodeActivity vcodeActivity, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            VcodeActivity.this.dQf = null;
            if (this.Ty != null) {
                this.Ty.gL();
            }
            this.aTV = true;
            VcodeActivity.this.mProgressBar.setVisibility(8);
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: r */
        public Bitmap doInBackground(String... strArr) {
            String str = strArr[0];
            if (str == null || str.length() <= 0) {
                this.Ty = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
                this.Ty.o(ImageViewerConfig.FORUM_ID, VcodeActivity.this.dPP.getForumId());
                this.Ty.o("kw", VcodeActivity.this.dPP.getForumName());
                this.Ty.o("new_vcode", "1");
                this.Ty.o("title", VcodeActivity.this.dPP.getTitle());
                this.Ty.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, VcodeActivity.this.dPP.getContent());
                if (VcodeActivity.this.dPP.getType() == 0) {
                    this.Ty.o("pub_type", "1");
                    if (VcodeActivity.this.dPP.getCategoryFrom() >= 0) {
                        this.Ty.o("fromCategoryId", String.valueOf(VcodeActivity.this.dPP.getCategoryFrom()));
                    }
                    if (VcodeActivity.this.dPP.getCategoryTo() >= 0) {
                        this.Ty.o("toCategoryId", String.valueOf(VcodeActivity.this.dPP.getCategoryTo()));
                    }
                } else {
                    this.Ty.o("pub_type", "2");
                    this.Ty.o("tid", VcodeActivity.this.dPP.getThreadId());
                }
                String ul = this.Ty.ul();
                if (!this.Ty.uM().vG().rf()) {
                    return null;
                }
                this.dQh = new com.baidu.tbadk.coreExtra.data.n();
                this.dQh.parserJson(ul);
                str = this.dQh.getVcode_pic_url();
            }
            if (this.aTV) {
                return null;
            }
            this.Ty = new com.baidu.tbadk.core.util.ab(str);
            return com.baidu.tbadk.core.util.c.N(this.Ty.um());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            VcodeActivity.this.dQf = null;
            if (bitmap != null) {
                VcodeActivity.this.aGW.setImageBitmap(bitmap);
            }
            VcodeActivity.this.mProgressBar.setVisibility(8);
            if (this.dQh != null) {
                VcodeActivity.this.dPP.setVcodeMD5(this.dQh.getVcode_md5());
                VcodeActivity.this.dPP.setVcodeUrl(this.dQh.getVcode_pic_url());
            }
            super.onPostExecute((a) bitmap);
        }
    }
}
