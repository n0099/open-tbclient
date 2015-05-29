package com.baidu.tieba.write.write;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.JigsawAlbumActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.editor.EditorInfoContainer;
import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, com.baidu.tbadk.core.voice.j, com.baidu.tieba.tbadkCore.ap, co {
    private com.baidu.tieba.tbadkCore.location.e aJM;
    private String aJR;
    private com.baidu.tieba.tbadkCore.writeModel.a aJT;
    private TextView cAA;
    private cn cAB;
    private ImageView cAC;
    private View cAD;
    private int cAd;
    private RelativeLayout cCA;
    private TextView cCB;
    private TextView cCC;
    private TextView cCD;
    private RelativeLayout cCF;
    private TextView cCG;
    private View cCH;
    private LiveBroadcastCard cCI;
    private com.baidu.tieba.view.a cCO;
    private View cCo;
    private Toast cCv;
    private AdditionData cCz;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private VoiceManager mVoiceManager;
    private WriteData cuo = null;
    private boolean cCk = false;
    private boolean cCl = false;
    private InputMethodManager mInputManager = null;
    private EditText cAu = null;
    private View cAv = null;
    private LinearLayout cAx = null;
    private EditText cAy = null;
    private t cCm = null;
    private FeedBackTopListView cCn = null;
    private ArrayList<com.baidu.tieba.write.view.j> cCp = new ArrayList<>();
    private String bCP = null;
    private final KeyEvent cCq = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView cCr = null;
    private TextView cAz = null;
    private TextView baH = null;
    private DialogInterface.OnCancelListener bSI = null;
    private com.baidu.tbadk.core.dialog.a cCs = null;
    private final Handler mHandler = new Handler();
    private boolean cCt = false;
    private String cCu = null;
    private RelativeLayout aZJ = null;
    private String bKu = null;
    private com.baidu.tieba.write.editor.b cCw = null;
    private TbEditorToolButtonContainer cCx = null;
    private EditorToolComponetContainer cqO = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private boolean cCy = false;
    private int cCE = 0;
    private final HttpMessageListener cCJ = new ai(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final com.baidu.tieba.tbadkCore.writeModel.e bKJ = new at(this);
    private final com.baidu.tieba.tbadkCore.location.j aJX = new bf(this);
    private final View.OnClickListener cCK = new bn(this);
    private final CustomMessageListener ctL = new bo(this, 2001232);
    private final Runnable cCL = new bp(this);
    private final View.OnClickListener cCM = new bq(this);
    private boolean cCN = true;
    private final View.OnFocusChangeListener cAs = new br(this);
    private final CustomMessageListener cqS = new bs(this, 2001310);
    private final com.baidu.tieba.tbadkCore.c.h bOz = new aj(this);

    public void JO() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void JP() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.t.location_system_permission_prompt);
            this.cCw.setLocationInfoViewState(0);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            JQ();
        } else if (this.aJM.apm()) {
            JO();
        } else {
            this.aJM.fi(false);
            this.cCw.setLocationInfoViewState(1);
            this.aJM.apk();
        }
    }

    private void JQ() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bu(com.baidu.tieba.t.location_app_permission_prompt).a(com.baidu.tieba.t.isopen, new ak(this)).b(com.baidu.tieba.t.cancel, new al(this)).b(getPageContext());
        aVar.rL();
    }

    public int ate() {
        int selectionEnd = this.cAy.getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.cAy.getText().getSpans(0, this.cAy.getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = this.cAy.getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = this.cAy.getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    public void atf() {
        if (!this.cCN) {
            this.cCx.anc();
        } else {
            this.cCx.and();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        this.cqO.anL();
        if (this.cCO != null && this.cuo != null && this.cuo.getLiveCardData() != null) {
            new Handler().postDelayed(new am(this, new Date(this.cuo.getLiveCardData().getStartTime() * 1000)), 100L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.cqO.anJ();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdLog.addLogPackage(WriteActivity.class.getPackage().getName());
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new bt(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        initUI();
        atk();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.cqS.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.cqS);
        this.aJM = new com.baidu.tieba.tbadkCore.location.e(this);
        this.aJM.a(this.aJX);
        registerListener(this.ctL);
        if (this.cCz == null) {
            JR();
        }
        this.cAy.requestFocus();
    }

    public void anV() {
        boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(2802001);
        if (!TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() || this.cCz != null || !appResponseToCmd) {
            this.cCx.asl();
        }
    }

    private void JR() {
        if (this.aJM.apo()) {
            if (this.aJM.apm()) {
                this.cCw.D(2, com.baidu.tieba.tbadkCore.location.d.aph().getLocationData().apd());
                return;
            }
            this.cCw.setLocationInfoViewState(1);
            this.aJM.apk();
            return;
        }
        this.cCw.setLocationInfoViewState(0);
    }

    public void asx() {
        if (this.aJT != null) {
            this.aJT.cancelLoadData();
        }
        if (this.cCm != null) {
            this.cCm.cancelLoadData();
        }
        if (this.aJM != null) {
            this.aJM.cancelLoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        asx();
        att();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
    }

    public void atg() {
        if (this.cuo != null && this.cuo.getType() == 2 && this.cCt) {
            finish();
        } else if (this.cuo == null) {
            finish();
        } else {
            this.cuo.setTitle(this.cAu.getText().toString());
            this.cuo.setContent(this.cAy.getText().toString());
            int type = this.cuo.getType();
            if (this.cuo.getHaveDraft() && com.baidu.adp.lib.util.m.isEmpty(this.cuo.getTitle()) && com.baidu.adp.lib.util.m.isEmpty(this.cuo.getContent()) && !this.cuo.isHasImages()) {
                if (type == 0) {
                    if (this.cuo.getLiveCardData() == null) {
                        com.baidu.tieba.tbadkCore.ao.a(this.cuo.getForumId(), (WriteData) null);
                    } else {
                        com.baidu.tieba.tbadkCore.ao.a(this.cuo.getLiveCardData().getGroupId(), (WriteData) null);
                    }
                } else if (type == 1) {
                    com.baidu.tieba.tbadkCore.ao.b(this.cuo.getThreadId(), (WriteData) null);
                }
            } else if (type == 0) {
                if (this.cuo.getLiveCardData() == null) {
                    com.baidu.tieba.tbadkCore.ao.a(this.cuo.getForumId(), this.cuo);
                } else {
                    com.baidu.tieba.tbadkCore.ao.a(this.cuo.getLiveCardData().getGroupId(), this.cuo);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.ao.b(this.cuo.getThreadId(), this.cuo);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cAB != null && this.cAB.isShowing()) {
                com.baidu.adp.lib.g.k.a(this.cAB, getPageContext().getPageActivity());
                return true;
            } else if (this.cqO.anw()) {
                this.cCx.ane();
                this.cqO.hideAll();
                return true;
            } else {
                asx();
                atg();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(this.aZJ);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.ay.g(this.cAz, i);
        atf();
        com.baidu.tbadk.core.util.ay.j(this.cAv, com.baidu.tieba.n.cp_bg_line_c);
        com.baidu.tbadk.core.util.ay.j((View) this.cAu, com.baidu.tieba.n.cp_bg_line_d);
        if (TextUtils.isEmpty(this.bCP)) {
            com.baidu.tbadk.core.util.ay.j((View) this.cAy, com.baidu.tieba.n.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.cp_cont_e);
        this.cCx.changeSkinType(i);
        this.cAu.setTextColor(color);
        this.cAy.setTextColor(color);
        a(this.cAu, color2);
        a(this.cAy, color2);
        asF();
        this.cqO.onChangeSkinType(i);
        this.cCw.rU();
    }

    private void a(EditText editText, int i) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText((CharSequence) null);
        editText.setHintTextColor(i);
        editText.setText(text);
        editText.setSelection(selectionStart, selectionEnd);
    }

    private void initUI() {
        setContentView(com.baidu.tieba.r.write_activity);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.baH = this.mNavigationBar.setTitleText("");
        this.cCr = (TextView) findViewById(com.baidu.tieba.q.btn_image_problem);
        this.cAz = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.t.send_post));
        this.cAz.setOnFocusChangeListener(this.cAs);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.cCn = (FeedBackTopListView) findViewById(com.baidu.tieba.q.feedback_top_list);
        this.aZJ = (RelativeLayout) findViewById(com.baidu.tieba.q.parent);
        this.cAv = findViewById(com.baidu.tieba.q.interval_view);
        asE();
        asG();
        if (this.cCk || this.cCl) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.httpNet.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.httpNet.e.getInstance().WL) {
                    com.baidu.tbadk.core.util.httpNet.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.httpNet.e.getInstance().hasImageProblem()) {
                    findViewById(com.baidu.tieba.q.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(com.baidu.tieba.q.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.cAx = (LinearLayout) findViewById(com.baidu.tieba.q.post_content_container);
        this.cAx.setDrawingCacheEnabled(false);
        this.cAx.setOnClickListener(new an(this));
        this.mBack.setOnFocusChangeListener(this.cAs);
        this.mBack.setOnClickListener(new ao(this));
        this.cCr.setOnClickListener(new ap(this));
        this.cCw = new com.baidu.tieba.write.editor.b((EditorInfoContainer) findViewById(com.baidu.tieba.q.write_editor_info));
        this.cCw.A(this.cCK);
        if (this.cCz != null) {
            this.cCw.destroy();
        }
        f(atu());
        ati();
        atq();
        atn();
        atl();
        anV();
        if (this.cuo.getType() == 0) {
            if (this.cCk || this.cCl) {
                this.cCx.asl();
                this.baH.setText(com.baidu.tieba.t.feedback);
            } else {
                this.baH.setText(com.baidu.tieba.t.post_new_thread);
            }
            this.cAu.setVisibility(0);
            this.cAy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
        } else {
            this.baH.setText(com.baidu.tieba.t.send_reply);
            this.cAy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
            this.cAu.setVisibility(8);
        }
        atm();
        ats();
        atf();
        atj();
        asD();
        asF();
        if (this.cuo.getLiveCardData() == null) {
            ShowSoftKeyPad(this.mInputManager, this.cAu);
        }
        ath();
    }

    private void ath() {
        if (this.cqO != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            this.cqO.setShadowHeight(getResources().getDimensionPixelSize(com.baidu.tieba.o.ds1));
            if (skinType == 1) {
                this.cqO.setShadowBackground(com.baidu.tieba.n.cp_bg_line_b_1);
            } else {
                this.cqO.setShadowBackground(com.baidu.tieba.n.cp_cont_e);
            }
        }
    }

    private void ati() {
        this.cCF = (RelativeLayout) findViewById(com.baidu.tieba.q.live_time_rel);
        this.cCG = (TextView) findViewById(com.baidu.tieba.q.live_tiem_show);
        this.cCH = findViewById(com.baidu.tieba.q.interval_view2);
        this.cCI = (LiveBroadcastCard) findViewById(com.baidu.tieba.q.live_anchor_card);
        this.cCF.setOnClickListener(new aq(this));
        this.cCF.setOnTouchListener(new ar(this));
        if (this.cuo.getLiveCardData() != null) {
            this.cCF.setVisibility(0);
            this.cCH.setVisibility(0);
            this.cCI.setVisibility(0);
            this.cCI.setClickable(false);
            this.cCG.setText(com.baidu.tbadk.core.util.bb.p(this.cuo.getLiveCardData().getStartTime() * 1000));
            this.cCI.setData(this.cuo.getLiveCardData());
            return;
        }
        this.cCF.setVisibility(8);
        this.cCH.setVisibility(8);
        this.cCI.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if ((dialog instanceof com.baidu.tieba.view.a) && this.cuo.getLiveCardData() != null) {
            Date date = new Date(this.cuo.getLiveCardData().getStartTime() * 1000);
            ((com.baidu.tieba.view.a) dialog).updateTime(date.getHours(), date.getMinutes());
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.cCO = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new as(this), new Date().getHours(), new Date().getMinutes(), false);
        this.cCO.setTitle(com.baidu.tieba.t.no_disturb_start_time);
        this.cCO.setButton(-1, getPageContext().getString(com.baidu.tieba.t.alert_yes_button), this.cCO);
        this.cCO.setButton(-2, getPageContext().getString(com.baidu.tieba.t.alert_no_button), this.cCO);
        return this.cCO;
    }

    private void atj() {
        this.cCA = (RelativeLayout) findViewById(com.baidu.tieba.q.addition_container);
        this.cCB = (TextView) findViewById(com.baidu.tieba.q.addition_create_time);
        this.cCC = (TextView) findViewById(com.baidu.tieba.q.addition_last_time);
        this.cCD = (TextView) findViewById(com.baidu.tieba.q.addition_last_content);
        if (this.cCz != null) {
            this.cCA.setVisibility(0);
            this.cCB.setText(String.valueOf(getPageContext().getString(com.baidu.tieba.t.write_addition_create)) + com.baidu.tbadk.core.util.bb.o(this.cCz.getCreateTime() * 1000));
            if (this.cCz.getAlreadyCount() == 0) {
                this.cCC.setVisibility(8);
            } else {
                this.cCC.setText(String.valueOf(getPageContext().getString(com.baidu.tieba.t.write_addition_last)) + com.baidu.tbadk.core.util.bb.o(this.cCz.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.cCz.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.cCD.setText(lastAdditionContent);
            } else {
                this.cCD.setVisibility(8);
            }
            this.cAy.setHint(String.format(getPageContext().getString(com.baidu.tieba.t.write_addition_hint), Integer.valueOf(this.cCz.getAlreadyCount()), Integer.valueOf(this.cCz.getTotalCount())));
            this.baH.setText(com.baidu.tieba.t.write_addition_title);
            return;
        }
        this.cCA.setVisibility(8);
    }

    private void asD() {
        this.cAD = findViewById(com.baidu.tieba.q.post_prefix_layout);
        this.cAA = (TextView) findViewById(com.baidu.tieba.q.post_prefix);
        this.cCo = findViewById(com.baidu.tieba.q.prefix_divider);
        this.cAC = (ImageView) findViewById(com.baidu.tieba.q.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.cAD.setVisibility(0);
            this.cCo.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.cAd = 1;
            this.cAD.setOnClickListener(new au(this));
            this.cAC = (ImageView) findViewById(com.baidu.tieba.q.prefix_icon);
            if (size > 1) {
                this.cAC.setVisibility(0);
                this.cAA.setOnClickListener(new av(this));
            }
            this.cAB = new cn(getPageContext().getPageActivity());
            this.cAB.a(this);
            this.cAB.setMaxHeight(com.baidu.adp.lib.util.n.d(getActivity(), com.baidu.tieba.o.ds510));
            this.cAB.setOutsideTouchable(true);
            this.cAB.setFocusable(true);
            this.cAB.setOnDismissListener(this);
            this.cAB.setBackgroundDrawable(com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.n.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.write_text);
            int color2 = com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.cp_cont_c);
            com.baidu.tbadk.core.util.ay.i((View) this.cAA, com.baidu.tieba.n.cp_bg_line_d);
            com.baidu.tbadk.core.util.ay.c(this.cAC, com.baidu.tieba.p.icon_title_down);
            this.cAA.setTextColor(color);
            this.cCp.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.view.j jVar = new com.baidu.tieba.write.view.j(getActivity());
                this.cCp.add(jVar);
                jVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    jVar.setPrefixTextColor(color2);
                } else {
                    jVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    jVar.setDividerStyle(false);
                }
                this.cAB.addView(jVar);
            }
            this.cAB.setCurrentIndex(0);
            this.cAA.setText(prefixs.get(1));
            jG(1);
            return;
        }
        this.cAD.setVisibility(8);
    }

    private void atk() {
        if (this.cCk && this.cuo != null) {
            this.cCn.setVisibility(0);
            this.cCm = new t(this);
            this.cCm.kd(this.cuo.getForumName());
            this.cCm.setLoadDataCallBack(new aw(this));
        }
    }

    protected void atl() {
        this.cAz.setOnClickListener(new ax(this));
    }

    protected void atm() {
        this.cCs = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cCs.cn(getPageContext().getString(com.baidu.tieba.t.is_save_draft)).ag(false).a(getPageContext().getString(com.baidu.tieba.t.save), new ay(this)).b(getPageContext().getString(com.baidu.tieba.t.not_save), new ba(this));
        this.cCs.b(getPageContext());
    }

    protected void asE() {
        this.cAu = (EditText) findViewById(com.baidu.tieba.q.post_title);
        this.cAu.setOnClickListener(this.cCM);
        this.cAu.setOnFocusChangeListener(this.cAs);
        if (this.cuo.getType() == 0) {
            if (this.cuo.getTitle() != null) {
                this.cAu.setText(this.cuo.getTitle());
                this.cAu.setSelection(this.cuo.getTitle().length());
            }
        } else if (this.cuo.getType() != 1) {
            this.cuo.getType();
        }
        this.cAu.addTextChangedListener(new bb(this));
    }

    protected void asG() {
        this.cAy = (EditText) findViewById(com.baidu.tieba.q.post_content);
        this.cAy.setDrawingCacheEnabled(false);
        this.cAy.setOnClickListener(this.cCM);
        if (this.cuo.getContent() != null && this.cuo.getContent().length() > 0) {
            SpannableString F = TbFaceManager.Ak().F(getPageContext().getPageActivity(), this.cuo.getContent());
            this.cAy.setText(F);
            this.cAy.setSelection(F.length());
        } else if (this.cuo.getType() == 2) {
            if (this.cCt) {
                if (this.cCu != null && this.cCu.length() > 0) {
                    this.cAy.setText(getPageContext().getPageActivity().getString(com.baidu.tieba.t.reply_sub_floor, new Object[]{this.cCu}));
                    this.cAy.setSelection(this.cAy.getText().length());
                }
            } else if (this.cuo.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(com.baidu.tieba.t.reply_x_floor), Integer.valueOf(this.cuo.getFloorNum()));
                this.cAy.setText(format);
                this.cAy.setSelection(format.length());
            }
        }
        this.cAy.setOnFocusChangeListener(this.cAs);
        this.cAy.setOnTouchListener(new bc(this));
        this.cAy.addTextChangedListener(new bd(this));
        fF(true);
    }

    public void fF(boolean z) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class)) {
            this.cAy.setPadding(0, 0, 0, 0);
            this.cAy.setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.ay.j((View) this.cAy, com.baidu.tieba.n.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.bCP) && this.cCz == null) {
                com.baidu.adp.lib.f.d.hl().a(this.bCP, 19, new be(this, z), getUniqueId());
            }
        }
    }

    public boolean Km() {
        int i = 5000;
        if (this.cCz != null) {
            i = 1000;
        }
        return this.cAy.getText() != null && this.cAy.getText().length() >= i;
    }

    protected void atn() {
        this.cqO = (EditorToolComponetContainer) findViewById(com.baidu.tieba.q.tool_group);
        this.cqO.setFrom(1);
        Boolean atu = atu();
        if (this.cCk || (atu != null && !atu.booleanValue())) {
            this.cqO.zV();
        } else if (this.cuo.getLiveCardData() != null) {
            this.cqO.zU();
        } else {
            this.cqO.zT();
        }
        if (!StringUtils.isNull(this.bKu)) {
            this.cqO.setAudioCanUse(false);
        }
        this.cqO.setOnActionListener(new bg(this));
        this.cqO.refresh();
    }

    protected void ato() {
        this.cCx.ane();
        if (this.cqO.anw()) {
            this.cqO.hideAll();
        }
    }

    public void atp() {
        this.cqO.ab(this.cAy);
    }

    public void jD(int i) {
        if (this.cqO.anw()) {
            jE(i);
            return;
        }
        this.cqO.aa(this.cAu);
        this.cqO.aa(this.cAy);
        new Handler().postDelayed(new bh(this, i), 200L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.cqO != null) {
            this.cqO.any();
        }
    }

    public void jE(int i) {
        if (i == 2) {
            this.cCx.ase();
            this.cqO.anA();
        } else if (i == 5 || i == 60) {
            this.cqO.anB();
        } else if (i == 8) {
            this.cqO.anC();
            this.cCx.asf();
        } else if (i == 50) {
            this.cqO.anE();
            this.cCx.asi();
        } else if (i == 44) {
            this.cqO.anD();
            this.cCx.asg();
        } else if (i == 38) {
            this.cqO.anz();
            this.cCx.asj();
        } else if (i == 57) {
            this.cqO.anC();
            this.cCx.asf();
        } else if (i == 48) {
            this.cqO.anE();
        }
    }

    protected void atq() {
        this.cCx = (TbEditorToolButtonContainer) findViewById(com.baidu.tieba.q.write_eidtor_tool_buttons);
        this.cCx.and();
        this.cCx.setAtFocusable(false);
        this.cCx.setOnActionListener(new bi(this));
        if (TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.cCx.fA(false);
        }
    }

    public void jF(int i) {
        if (this.cqO.anG()) {
            jD(i);
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.amV() && this.cCE == 0) {
            showToast(com.baidu.tieba.t.baobao_over_limit);
        } else {
            String charSequence = this.baH.getText().toString();
            com.baidu.tbadk.core.frameworkData.c cVar = new com.baidu.tbadk.core.frameworkData.c(getPageContext().getPageActivity());
            cVar.getIntent().putExtra("title", charSequence);
            cVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage(2802001, cVar));
        }
    }

    public void a(com.baidu.tbadk.coreExtra.data.f fVar) {
        if (((ImageSpan[]) this.cAy.getText().getSpans(0, this.cAy.getText().length(), ImageSpan.class)).length >= 10) {
            if (this.cCv == null) {
                this.cCv = Toast.makeText(getPageContext().getPageActivity(), com.baidu.tieba.t.too_many_face, 0);
            }
            this.cCv.show();
            return;
        }
        String name = fVar.getName();
        EmotionGroupType vm = fVar.vm();
        if (name != null) {
            com.baidu.adp.lib.f.d.hl().a(name, 20, new bj(this, new SpannableStringBuilder(name), this.cAy.getSelectionStart(), vm), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap mS = aVar.mS();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(mS);
        int width = mS.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        this.cAy.getText().insert(i, spannableStringBuilder);
    }

    public void atr() {
        this.cAy.onKeyDown(67, this.cCq);
    }

    private void f(Boolean bool) {
        String str = null;
        if (this.cuo != null) {
            str = this.cuo.getForumName();
        }
        if (getPageContext().getString(com.baidu.tieba.t.feedback_bar_name).equals(str)) {
            this.cCk = true;
        }
    }

    private void ats() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void att() {
        try {
            if (this.cCs != null) {
                this.cCs.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        super.showLoadingDialog(str, onCancelListener);
        if (this.mWaitingDialog != null) {
            this.mWaitingDialog.setCanceledOnTouchOutside(false);
        }
    }

    private Boolean atu() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.bKu = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void asF() {
        String str = null;
        if (this.cuo.getType() == 0) {
            String trim = this.cAu.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                this.mPrefixData.getPrefixs();
                if (this.cAd == 0) {
                    if (TextUtils.isEmpty(trim)) {
                        this.cuo.setIsNoTitle(true);
                    } else {
                        this.cuo.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.cuo.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.cuo.setIsNoTitle(true);
            } else {
                this.cuo.setIsNoTitle(false);
                str = "1";
            }
        }
        String trim2 = this.cAy.getText().toString().trim();
        if (this.cqO.anF()) {
            str = "1";
        } else if (!TextUtils.isEmpty(trim2)) {
            str = "1";
        } else if (this.cqO.anH()) {
            str = "1";
        } else if (this.cqO.anG()) {
            str = "1";
        }
        if (str == null || str.length() <= 0) {
            this.cAz.setEnabled(false);
        } else {
            this.cAz.setEnabled(true);
        }
    }

    private void initData(Bundle bundle) {
        this.aJT = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aJT.a(this.bKJ);
        registerListener(this.cCJ);
        this.bSI = new bk(this);
        this.cuo = new WriteData();
        if (bundle != null) {
            this.cuo.setType(bundle.getInt("type", 0));
            this.cuo.setForumId(bundle.getString("forum_id"));
            this.cuo.setForumName(bundle.getString("forum_name"));
            this.cuo.setThreadId(bundle.getString("thread_id"));
            this.cuo.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.cuo.setFloorNum(bundle.getInt(WriteActivityConfig.FLOOR_NUM, 0));
            this.cCk = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.cCt = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.cCu = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.aJR = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.cCz = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.cuo.setIsAddition(this.cCz != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.cCE = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            if (bundle.getBoolean(WriteActivityConfig.IS_LIVE_POST)) {
                LiveCardData liveCardData = new LiveCardData();
                liveCardData.setStartTime(bundle.getLong(WriteActivityConfig.LIVE_DATE));
                liveCardData.setAuthorName(bundle.getString(WriteActivityConfig.LIVE_GROUP_PUBLISH_NAME));
                liveCardData.setPortrait(bundle.getString(WriteActivityConfig.LIVE_GROUP_HEAD));
                liveCardData.setIntro(bundle.getString(WriteActivityConfig.LIVE_GROUP_INTRO));
                liveCardData.setListeners(bundle.getInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, 0));
                liveCardData.setName(bundle.getString(WriteActivityConfig.LIVE_GROUP_NAME));
                liveCardData.setLikers(bundle.getInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, 0));
                liveCardData.setGroupId(bundle.getInt(WriteActivityConfig.LIVE_GROUP_ID, 0));
                liveCardData.setModifyTime(bundle.getBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY));
                liveCardData.setPublisherPortrait(bundle.getString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD));
                this.cuo.setLiveCardData(liveCardData);
            }
        } else {
            Intent intent = getIntent();
            this.cuo.setType(intent.getIntExtra("type", 0));
            this.cuo.setForumId(intent.getStringExtra("forum_id"));
            this.cuo.setForumName(intent.getStringExtra("forum_name"));
            this.cuo.setThreadId(intent.getStringExtra("thread_id"));
            this.cuo.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.cuo.setFloorNum(intent.getIntExtra(WriteActivityConfig.FLOOR_NUM, 0));
            this.cCk = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.cCt = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.cCu = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.cCz = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.cuo.setIsAddition(this.cCz != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.cCE = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            if (intent.getBooleanExtra(WriteActivityConfig.IS_LIVE_POST, false)) {
                LiveCardData liveCardData2 = new LiveCardData();
                liveCardData2.setStartTime(new Date().getTime() / 1000);
                liveCardData2.setAuthorName(intent.getStringExtra(WriteActivityConfig.LIVE_GROUP_PUBLISH_NAME));
                liveCardData2.setPortrait(intent.getStringExtra(WriteActivityConfig.LIVE_GROUP_HEAD));
                liveCardData2.setIntro(intent.getStringExtra(WriteActivityConfig.LIVE_GROUP_INTRO));
                liveCardData2.setListeners(intent.getIntExtra(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, 0));
                liveCardData2.setName(intent.getStringExtra(WriteActivityConfig.LIVE_GROUP_NAME));
                liveCardData2.setLikers(intent.getIntExtra(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, 0));
                liveCardData2.setGroupId(intent.getIntExtra(WriteActivityConfig.LIVE_GROUP_ID, 0));
                liveCardData2.setPublisherPortrait(intent.getStringExtra(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD));
                this.cuo.setLiveCardData(liveCardData2);
            }
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(10);
        this.cuo.setWriteImagesInfo(this.writeImagesInfo);
        this.cuo.setBaobaoImagesInfo(this.baobaoImagesInfo);
        if (this.cuo.getType() == 0) {
            if (this.cuo.getLiveCardData() == null) {
                com.baidu.tieba.tbadkCore.ao.c(this.cuo.getForumId(), this);
            } else {
                com.baidu.tieba.tbadkCore.ao.a(this.cuo.getLiveCardData().getGroupId(), this);
            }
        } else if (this.cuo.getType() == 1) {
            com.baidu.tieba.tbadkCore.ao.a(this.cuo.getThreadId(), this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(com.baidu.tieba.t.write_no_prefix));
        }
        this.bCP = TbadkCoreApplication.m411getInst().getDefaultBubble();
        if (this.cuo != null && this.cuo.getForumName() != null && TbadkCoreApplication.m411getInst().getYijianfankuiFname() != null && this.cuo.getForumName().equals(TbadkCoreApplication.m411getInst().getYijianfankuiFname())) {
            this.cCl = true;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ap
    public void a(WriteData writeData) {
        if (writeData != null && this.cuo != null) {
            this.cuo.setHaveDraft(true);
            if (com.baidu.adp.lib.util.m.isEmpty(this.cAu.getText().toString()) || ((this.cCk || this.cCl) && !com.baidu.adp.lib.util.m.isEmpty(writeData.getTitle()))) {
                this.cuo.setTitle(writeData.getTitle());
                this.cAu.setText(this.cuo.getTitle());
                this.cAu.setSelection(this.cuo.getTitle().length());
            }
            if (writeData.getLiveCardData() != null) {
                Date date = new Date(writeData.getLiveCardData().getStartTime() * 1000);
                Date date2 = new Date();
                date.setYear(date2.getYear());
                date.setMonth(date2.getMonth());
                date.setDate(date2.getDate());
                this.cuo.getLiveCardData().setStartTime(date.getTime() / 1000);
                this.cCG.setText(com.baidu.tbadk.core.util.bb.p(this.cuo.getLiveCardData().getStartTime() * 1000));
            }
            if ((com.baidu.adp.lib.util.m.isEmpty(this.cAy.getText().toString()) || this.cCk || this.cCl) && !com.baidu.adp.lib.util.m.isEmpty(writeData.getContent())) {
                this.cuo.setContent(writeData.getContent());
                SpannableString a = TbFaceManager.Ak().a(getPageContext().getPageActivity(), this.cuo.getContent(), new bl(this));
                this.cAy.setText(a);
                this.cAy.setSelection(a.length());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo = writeData.getWriteImagesInfo();
                this.cuo.setWriteImagesInfo(this.writeImagesInfo);
                this.cqO.a(this.writeImagesInfo, true);
                fG(false);
            }
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen()) {
                if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                    this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                    this.cuo.setIsBaobao(writeData.getIsBaobao());
                    this.cuo.setBaobaoContent(writeData.getBaobaoContent());
                    this.cuo.setBaobaoImagesInfo(this.baobaoImagesInfo);
                }
                if (this.cuo.getIsBaobao()) {
                    this.cqO.setBaobaoUris(this.baobaoImagesInfo);
                    fH(false);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.cuo.getType());
        bundle.putString("forum_id", this.cuo.getForumId());
        bundle.putString("forum_name", this.cuo.getForumName());
        bundle.putString("thread_id", this.cuo.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.cuo.getFloor());
        bundle.putInt(WriteActivityConfig.FLOOR_NUM, this.cuo.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.cCt);
        if (this.cCk) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aJR);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.cCz);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.cCE);
        if (this.cuo.getLiveCardData() != null) {
            bundle.putBoolean(WriteActivityConfig.IS_LIVE_POST, true);
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ID, this.cuo.getLiveCardData().getGroupId());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_HEAD, this.cuo.getLiveCardData().getPortrait());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_INTRO, this.cuo.getLiveCardData().getIntro());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_NAME, this.cuo.getLiveCardData().getName());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, this.cuo.getLiveCardData().getListeners());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, this.cuo.getLiveCardData().getLikers());
            bundle.putLong(WriteActivityConfig.LIVE_DATE, this.cuo.getLiveCardData().getStartTime());
            bundle.putBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY, this.cuo.getLiveCardData().isModifyTime());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD, this.cuo.getLiveCardData().getPublisherPortrait());
        }
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = this.cAy.getEditableText().toString();
        if (editable != null) {
            this.cAy.setText(TbFaceManager.Ak().F(getPageContext().getPageActivity(), editable));
            this.cAy.setSelection(this.cAy.getText().length());
        }
    }

    public void asA() {
        asx();
        if (this.cuo.getLiveCardData() != null) {
            if (!this.cuo.getLiveCardData().isModifyTime()) {
                this.cuo.getLiveCardData().setStartTime(new Date().getTime() / 1000);
                this.cCG.setText(com.baidu.tbadk.core.util.bb.p(this.cuo.getLiveCardData().getStartTime() * 1000));
            }
            long time = new Date().getTime() / TbConfig.USE_TIME_INTERVAL;
            Date date = new Date(this.cuo.getLiveCardData().getStartTime() * 1000);
            Date date2 = new Date();
            date.setYear(date2.getYear());
            date.setMonth(date2.getMonth());
            date.setDate(date2.getDate());
            this.cuo.getLiveCardData().setStartTime(date.getTime() / 1000);
            if (time > this.cuo.getLiveCardData().getStartTime() / 60) {
                showToast(com.baidu.tieba.t.live_start_time_error);
                return;
            }
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.cAd != 0) {
            this.cuo.setTitle(String.valueOf(this.cAA.getText().toString()) + this.cAu.getText().toString());
        } else {
            this.cuo.setTitle(this.cAu.getText().toString());
        }
        this.cuo.setContent(this.cAy.getText().toString());
        if (this.cCk || this.cCl) {
            String string = getResources().getString(com.baidu.tieba.t.android_feedback);
            if (TextUtils.isEmpty(this.cuo.getTitle()) || !this.cuo.getTitle().startsWith(string)) {
                this.cuo.setTitle(string + this.cuo.getTitle());
            }
            String str = String.valueOf(getResources().getString(com.baidu.tieba.t.app_name)) + getResources().getString(com.baidu.tieba.t.tieba_client);
            if (TextUtils.isEmpty(this.cuo.getContent()) || !this.cuo.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.k.iX()) {
                    sb.append(com.baidu.adp.lib.util.k.je());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.cuo.getContent());
                this.cuo.setContent(sb.toString());
            }
        }
        this.cuo.setWriteImagesInfo(this.writeImagesInfo);
        this.cuo.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.cuo.setHasLocationData(this.cCw.getLocationInfoViewState() == 2);
        this.aJT.fj(this.writeImagesInfo.size() > 0);
        this.aJT.c(this.cuo);
        VoiceData.VoiceModel audioData = this.cqO.getAudioData();
        this.cqO.Kr();
        this.cuo.setVcode(null);
        if (audioData != null) {
            if (audioData.getId() != null) {
                this.aJT.JS().setVoice(audioData.getId());
                this.aJT.JS().setVoiceDuringTime(audioData.duration);
            } else {
                this.aJT.JS().setVoice(null);
                this.aJT.JS().setVoiceDuringTime(-1);
            }
        } else {
            this.aJT.JS().setVoice(null);
            this.aJT.JS().setVoiceDuringTime(-1);
        }
        if (!this.aJT.apJ()) {
            showToast(com.baidu.tieba.t.write_img_limit);
        } else if (this.aJT.apH()) {
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.t.sending), this.bSI);
        }
    }

    private void l(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.cCz != null) {
                i2 = this.cCz.getTotalCount();
                i = this.cCz.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(com.baidu.tieba.t.write_addition_left_count), Integer.valueOf(i2 - i)));
            }
        }
        com.baidu.adp.lib.util.n.showToast(getPageContext().getPageActivity(), sb.toString());
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 12004) {
                ArrayList<String> U = com.baidu.tieba.tbadkCore.util.i.U(intent);
                if (U != null && U.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < U.size()) {
                            sb.append("@");
                            sb.append(U.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            String sb2 = sb.toString();
                            this.cAy.getText().insert(this.cAy.getSelectionStart(), sb2);
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                if (this.cuo.getType() == 0) {
                    com.baidu.tieba.tbadkCore.ao.a(this.cuo.getForumId(), (WriteData) null);
                } else if (this.cuo.getType() == 1) {
                    com.baidu.tieba.tbadkCore.ao.b(this.cuo.getThreadId(), (WriteData) null);
                }
                setResult(-1, intent);
                finish();
            } else if (i == 12002) {
                if (intent != null) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        Z(intent);
                    } else {
                        Y(intent);
                    }
                }
            } else if (i == 12012) {
                J(intent);
                asF();
            } else if (i == 12013) {
                S(intent);
                asF();
            } else if (i == 23004) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    JT();
                    return;
                case 12002:
                    if (!this.cqO.anF()) {
                        ato();
                    }
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                        return;
                    }
                    return;
                case 12009:
                    sendMessage(new CustomMessage(2002001, new JigsawAlbumActivityConfig(getPageContext().getPageActivity(), 12002)));
                    return;
                case 12010:
                    this.aJR = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.ax.a(getPageContext(), this.aJR);
                    return;
                default:
                    return;
            }
        }
    }

    private void Y(Intent intent) {
        P(intent);
        asF();
        this.cqO.setVisibility(0);
    }

    private void Z(Intent intent) {
        int size;
        K(intent);
        int size2 = this.writeImagesInfo.size() - 1;
        if (size2 > -1 && this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size2)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.cAu);
        HidenSoftKeyPad(this.mInputManager, this.cAy);
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void P(Intent intent) {
        b(intent, true);
    }

    public boolean atv() {
        boolean anH = this.cqO.anH();
        LinkedList<ImageFileInfo> chosedFiles = this.baobaoImagesInfo.getChosedFiles();
        return !anH && (chosedFiles == null || chosedFiles.isEmpty());
    }

    private void K(Intent intent) {
        this.aJR = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aJR;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cu = com.baidu.tbadk.core.util.c.cu(str);
                if (cu != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.c.h(b, cu);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.o.a(TbConfig.LOCAL_CAMERA_DIR, this.aJR, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            this.cqO.a(this.writeImagesInfo, true);
        }
        fG(true);
    }

    private void J(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    this.cqO.a(this.writeImagesInfo, z);
                }
            }
            fG(true);
        }
    }

    private void S(Intent intent) {
        if (this.cuo != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.cuo.setIsBaobao(true);
            this.cuo.setBaobaoContent(stringExtra2);
            this.cqO.setBaobaoUris(this.baobaoImagesInfo);
            fH(true);
        }
    }

    private void JT() {
        new bm(this).execute(new Void[0]);
    }

    private void fG(boolean z) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.cCx.eC(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            this.cCy = true;
            this.cqO.eC(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            if (this.cqO.anw() || z) {
                this.cqO.anC();
                return;
            }
            return;
        }
        this.cCx.zI();
        this.cCy = false;
        this.cqO.zI();
        if (this.cqO.anH()) {
            this.cqO.zQ();
            this.cCx.aod();
        }
        ato();
    }

    private void fH(boolean z) {
        LinkedList<ImageFileInfo> chosedFiles = this.baobaoImagesInfo.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.cCx.asi();
            this.cCx.aod();
            if (this.cqO.anw() || z) {
                this.cqO.anE();
            }
            this.cuo.setIsBaobao(true);
            return;
        }
        if (atv()) {
            this.cCx.aoe();
        }
        this.cuo.setIsBaobao(false);
        this.cCx.ash();
        ato();
    }

    @Override // com.baidu.tbadk.core.voice.j
    public synchronized VoiceManager getVoiceManager() {
        if (this.mVoiceManager == null) {
            this.mVoiceManager = VoiceManager.instance();
        }
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.voice.j
    public com.baidu.tbadk.core.voice.i getRealView(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    public synchronized void stopVoice() {
        this.mVoiceManager = getVoiceManager();
        this.mVoiceManager.stopPlay();
    }

    public void a(boolean z, AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        String str = "";
        if (postWriteCallBackData != null) {
            str = postWriteCallBackData.getErrorString();
        }
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.cuo.getForumName());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.WRITE);
        } else if (this.cCz == null) {
            com.baidu.tieba.tbadkCore.writeModel.h.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        } else {
            l(z, str);
        }
    }

    public void a(boolean z, AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.cuo.getForumName());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.WRITE);
        } else if (this.cCz == null) {
            com.baidu.tieba.tbadkCore.writeModel.h.O(getPageContext().getPageActivity(), str);
        } else {
            l(z, str);
        }
    }

    private void jG(int i) {
        if (i < this.cCp.size()) {
            for (int i2 = 0; i2 < this.cCp.size(); i2++) {
                this.cCp.get(i2).fD(false);
            }
            this.cCp.get(i).fD(true);
        }
    }

    @Override // com.baidu.tieba.write.write.co
    public void jv(int i) {
        this.cAd = i;
        this.cAB.setCurrentIndex(i);
        jG(i);
        this.cAA.setText(this.mPrefixData.getPrefixs().get(i));
        asF();
        com.baidu.adp.lib.g.k.a(this.cAB, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.cAD.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
