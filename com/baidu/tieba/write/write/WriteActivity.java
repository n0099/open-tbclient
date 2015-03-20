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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, com.baidu.tbadk.core.voice.j, com.baidu.tieba.tbadkCore.ap, cn {
    private String aHA;
    private com.baidu.tieba.tbadkCore.writeModel.a aHC;
    private com.baidu.tieba.tbadkCore.location.e aHv;
    private View cvQ;
    private TextView cvU;
    private cm cvV;
    private ImageView cvW;
    private View cvX;
    private int cvx;
    private Toast cxI;
    private AdditionData cxM;
    private RelativeLayout cxN;
    private TextView cxO;
    private TextView cxP;
    private TextView cxQ;
    private RelativeLayout cxS;
    private TextView cxT;
    private View cxU;
    private LiveBroadcastCard cxV;
    private com.baidu.tieba.view.a cyb;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private VoiceManager mVoiceManager;
    private WriteData cpU = null;
    private boolean cxz = false;
    private boolean cxA = false;
    private InputMethodManager mInputManager = null;
    private EditText cvO = null;
    private View cvP = null;
    private LinearLayout cvR = null;
    private EditText cvS = null;
    private s cxB = null;
    private FeedBackTopListView cxC = null;
    private String bzO = null;
    private final KeyEvent cxD = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView cxE = null;
    private TextView cvT = null;
    private TextView aXK = null;
    private DialogInterface.OnCancelListener ccA = null;
    private com.baidu.tbadk.core.dialog.a cxF = null;
    private final Handler mHandler = new Handler();
    private boolean cxG = false;
    private String cxH = null;
    private RelativeLayout aWN = null;
    private String bHS = null;
    private com.baidu.tieba.write.editor.b cxJ = null;
    private TbEditorToolButtonContainer cxK = null;
    private EditorToolComponetContainer cmz = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private boolean cxL = false;
    private int cxR = 0;
    private final HttpMessageListener cxW = new ah(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final com.baidu.tieba.tbadkCore.writeModel.e bIk = new as(this);
    private final com.baidu.tieba.tbadkCore.location.j aHH = new be(this);
    private final View.OnClickListener cxX = new bm(this);
    private final CustomMessageListener cpu = new bn(this, 2001232);
    private final Runnable cxY = new bo(this);
    private final View.OnClickListener cxZ = new bp(this);
    private boolean cya = true;
    private final View.OnFocusChangeListener cvM = new bq(this);
    private final CustomMessageListener cmD = new br(this, 2001310);
    private final com.baidu.tieba.tbadkCore.b.h bMf = new ai(this);

    public void II() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void IJ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.y.location_system_permission_prompt);
            this.cxJ.setLocationInfoViewState(0);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            IK();
        } else if (this.aHv.ang()) {
            II();
        } else {
            this.aHv.eR(false);
            this.cxJ.setLocationInfoViewState(1);
            this.aHv.ane();
        }
    }

    private void IK() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bx(com.baidu.tieba.y.location_app_permission_prompt).a(com.baidu.tieba.y.isopen, new aj(this)).b(com.baidu.tieba.y.cancel, new ak(this)).b(getPageContext());
        aVar.re();
    }

    public int aqZ() {
        int selectionEnd = this.cvS.getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.cvS.getText().getSpans(0, this.cvS.getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = this.cvS.getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = this.cvS.getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    public void ara() {
        if (!this.cya) {
            this.cxK.alc();
        } else {
            this.cxK.ald();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        this.cmz.alK();
        if (this.cyb != null && this.cpU != null && this.cpU.getLiveCardData() != null) {
            new Handler().postDelayed(new al(this, new Date(this.cpU.getLiveCardData().getStartTime() * 1000)), 100L);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.cmz.alI();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdLog.addLogPackage(WriteActivity.class.getPackage().getName());
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new bs(this, null));
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        initUI();
        arf();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.cmD.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.cmD);
        this.aHv = new com.baidu.tieba.tbadkCore.location.e(this);
        this.aHv.a(this.aHH);
        registerListener(this.cpu);
        if (this.cxM == null) {
            IL();
        }
        this.cvS.requestFocus();
    }

    public void alU() {
        boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(2802001);
        if (!TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() || this.cxM != null || !appResponseToCmd) {
            this.cxK.aqg();
        }
    }

    private void IL() {
        if (this.aHv.ani()) {
            if (this.aHv.ang()) {
                this.cxJ.B(2, com.baidu.tieba.tbadkCore.location.d.anb().getLocationData().amX());
                return;
            }
            this.cxJ.setLocationInfoViewState(1);
            this.aHv.ane();
            return;
        }
        this.cxJ.setLocationInfoViewState(0);
    }

    public void aqs() {
        if (this.aHC != null) {
            this.aHC.cancelLoadData();
        }
        if (this.cxB != null) {
            this.cxB.cancelLoadData();
        }
        if (this.aHv != null) {
            this.aHv.cancelLoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        aqs();
        aro();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
    }

    public void arb() {
        if (this.cpU != null && this.cpU.getType() == 2 && this.cxG) {
            finish();
        } else if (this.cpU == null) {
            finish();
        } else {
            this.cpU.setTitle(this.cvO.getText().toString());
            this.cpU.setContent(this.cvS.getText().toString());
            int type = this.cpU.getType();
            if (this.cpU.getHaveDraft() && com.baidu.adp.lib.util.m.isEmpty(this.cpU.getTitle()) && com.baidu.adp.lib.util.m.isEmpty(this.cpU.getContent()) && !this.cpU.isHasImages()) {
                if (type == 0) {
                    if (this.cpU.getLiveCardData() == null) {
                        com.baidu.tieba.tbadkCore.ao.a(this.cpU.getForumId(), (WriteData) null);
                    } else {
                        com.baidu.tieba.tbadkCore.ao.a(this.cpU.getLiveCardData().getGroupId(), (WriteData) null);
                    }
                } else if (type == 1) {
                    com.baidu.tieba.tbadkCore.ao.b(this.cpU.getThreadId(), (WriteData) null);
                }
            } else if (type == 0) {
                if (this.cpU.getLiveCardData() == null) {
                    com.baidu.tieba.tbadkCore.ao.a(this.cpU.getForumId(), this.cpU);
                } else {
                    com.baidu.tieba.tbadkCore.ao.a(this.cpU.getLiveCardData().getGroupId(), this.cpU);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.ao.b(this.cpU.getThreadId(), this.cpU);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cvV != null && this.cvV.isShowing()) {
                com.baidu.adp.lib.g.k.a(this.cvV, getPageContext().getPageActivity());
                return true;
            } else if (this.cmz.alv()) {
                this.cxK.ale();
                this.cmz.hideAll();
                return true;
            } else {
                aqs();
                arb();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.aWN);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.ba.g(this.cvT, i);
        ara();
        com.baidu.tbadk.core.util.ba.j(this.cvP, com.baidu.tieba.s.cp_bg_line_c);
        com.baidu.tbadk.core.util.ba.j(this.cvQ, com.baidu.tieba.s.cp_bg_line_c);
        com.baidu.tbadk.core.util.ba.j((View) this.cvO, com.baidu.tieba.s.cp_bg_line_d);
        if (TextUtils.isEmpty(this.bzO)) {
            com.baidu.tbadk.core.util.ba.j((View) this.cvS, com.baidu.tieba.s.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.ba.getColor(com.baidu.tieba.s.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.ba.getColor(com.baidu.tieba.s.cp_cont_e);
        this.cxK.changeSkinType(i);
        this.cvO.setTextColor(color);
        this.cvS.setTextColor(color);
        a(this.cvO, color2);
        a(this.cvS, color2);
        aqA();
        this.cmz.onChangeSkinType(i);
        this.cxJ.rk();
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
        setContentView(com.baidu.tieba.w.write_activity);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aXK = this.mNavigationBar.setTitleText("");
        this.cxE = (TextView) findViewById(com.baidu.tieba.v.btn_image_problem);
        this.cvT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.y.send_post));
        this.cvT.setOnFocusChangeListener(this.cvM);
        addGlobalLayoutListener();
        this.cxC = (FeedBackTopListView) findViewById(com.baidu.tieba.v.feedback_top_list);
        this.aWN = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.cvP = findViewById(com.baidu.tieba.v.interval_view);
        this.cvQ = findViewById(com.baidu.tieba.v.prefix_interval_view);
        aqz();
        aqB();
        if (this.cxz || this.cxA) {
            getWindow().setSoftInputMode(18);
            if (!com.baidu.tbadk.core.util.httpNet.e.getInstance().Wb) {
                com.baidu.tbadk.core.util.httpNet.e.getInstance().init();
            }
            if (com.baidu.tbadk.core.util.httpNet.e.getInstance().hasImageProblem()) {
                findViewById(com.baidu.tieba.v.ll_image_problem).setVisibility(0);
            } else {
                findViewById(com.baidu.tieba.v.ll_image_problem).setVisibility(8);
            }
        }
        this.cvR = (LinearLayout) findViewById(com.baidu.tieba.v.post_content_container);
        this.cvR.setDrawingCacheEnabled(false);
        this.cvR.setOnClickListener(new am(this));
        this.mBack.setOnFocusChangeListener(this.cvM);
        this.mBack.setOnClickListener(new an(this));
        this.cxE.setOnClickListener(new ao(this));
        this.cxJ = new com.baidu.tieba.write.editor.b((EditorInfoContainer) findViewById(com.baidu.tieba.v.write_editor_info));
        this.cxJ.B(this.cxX);
        if (this.cxM != null) {
            this.cxJ.destroy();
        }
        f(arp());
        ard();
        arl();
        ari();
        arg();
        alU();
        if (this.cpU.getType() == 0) {
            if (this.cxz || this.cxA) {
                this.cxK.aqg();
                this.aXK.setText(com.baidu.tieba.y.feedback);
            } else {
                this.aXK.setText(com.baidu.tieba.y.post_new_thread);
            }
            this.cvO.setVisibility(0);
            this.cvS.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
        } else {
            this.aXK.setText(com.baidu.tieba.y.send_reply);
            this.cvS.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
            this.cvO.setVisibility(8);
        }
        arh();
        arn();
        ara();
        are();
        aqy();
        aqA();
        if (this.cpU.getLiveCardData() == null) {
            ShowSoftKeyPad(this.mInputManager, this.cvO);
        }
        arc();
    }

    private void arc() {
        if (this.cmz != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            this.cmz.setShadowHeight(getResources().getDimensionPixelSize(com.baidu.tieba.t.ds1));
            if (skinType == 1) {
                this.cmz.setShadowBackground(com.baidu.tieba.s.cp_bg_line_b_1);
            } else {
                this.cmz.setShadowBackground(com.baidu.tieba.s.cp_cont_e);
            }
        }
    }

    private void ard() {
        this.cxS = (RelativeLayout) findViewById(com.baidu.tieba.v.live_time_rel);
        this.cxT = (TextView) findViewById(com.baidu.tieba.v.live_tiem_show);
        this.cxU = findViewById(com.baidu.tieba.v.interval_view2);
        this.cxV = (LiveBroadcastCard) findViewById(com.baidu.tieba.v.live_anchor_card);
        this.cxS.setOnClickListener(new ap(this));
        this.cxS.setOnTouchListener(new aq(this));
        if (this.cpU.getLiveCardData() != null) {
            this.cxS.setVisibility(0);
            this.cxU.setVisibility(0);
            this.cxV.setVisibility(0);
            this.cxV.setClickable(false);
            this.cxT.setText(com.baidu.tbadk.core.util.bd.o(this.cpU.getLiveCardData().getStartTime() * 1000));
            this.cxV.setData(this.cpU.getLiveCardData());
            return;
        }
        this.cxS.setVisibility(8);
        this.cxU.setVisibility(8);
        this.cxV.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if ((dialog instanceof com.baidu.tieba.view.a) && this.cpU.getLiveCardData() != null) {
            Date date = new Date(this.cpU.getLiveCardData().getStartTime() * 1000);
            ((com.baidu.tieba.view.a) dialog).updateTime(date.getHours(), date.getMinutes());
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.cyb = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new ar(this), new Date().getHours(), new Date().getMinutes(), false);
        this.cyb.setTitle(com.baidu.tieba.y.no_disturb_start_time);
        this.cyb.setButton(-1, getPageContext().getString(com.baidu.tieba.y.alert_yes_button), this.cyb);
        this.cyb.setButton(-2, getPageContext().getString(com.baidu.tieba.y.alert_no_button), this.cyb);
        return this.cyb;
    }

    private void are() {
        this.cxN = (RelativeLayout) findViewById(com.baidu.tieba.v.addition_container);
        this.cxO = (TextView) findViewById(com.baidu.tieba.v.addition_create_time);
        this.cxP = (TextView) findViewById(com.baidu.tieba.v.addition_last_time);
        this.cxQ = (TextView) findViewById(com.baidu.tieba.v.addition_last_content);
        if (this.cxM != null) {
            this.cxN.setVisibility(0);
            this.cxO.setText(String.valueOf(getPageContext().getString(com.baidu.tieba.y.write_addition_create)) + com.baidu.tbadk.core.util.bd.n(this.cxM.getCreateTime() * 1000));
            if (this.cxM.getAlreadyCount() == 0) {
                this.cxP.setVisibility(8);
            } else {
                this.cxP.setText(String.valueOf(getPageContext().getString(com.baidu.tieba.y.write_addition_last)) + com.baidu.tbadk.core.util.bd.n(this.cxM.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.cxM.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.cxQ.setText(lastAdditionContent);
            } else {
                this.cxQ.setVisibility(8);
            }
            this.cvS.setHint(String.format(getPageContext().getString(com.baidu.tieba.y.write_addition_hint), Integer.valueOf(this.cxM.getAlreadyCount()), Integer.valueOf(this.cxM.getTotalCount())));
            this.aXK.setText(com.baidu.tieba.y.write_addition_title);
            return;
        }
        this.cxN.setVisibility(8);
    }

    private void aqy() {
        this.cvX = findViewById(com.baidu.tieba.v.post_prefix_layout);
        this.cvU = (TextView) findViewById(com.baidu.tieba.v.post_prefix);
        this.cvW = (ImageView) findViewById(com.baidu.tieba.v.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.cvX.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.cvU.setText(prefixs.get(0));
            this.cvx = 0;
            this.cvX.setOnClickListener(new at(this));
            this.cvW = (ImageView) findViewById(com.baidu.tieba.v.prefix_icon);
            if (size > 1) {
                this.cvW.setVisibility(0);
                this.cvU.setOnClickListener(new au(this));
            }
            this.cvV = new cm(getPageContext().getPageActivity());
            this.cvV.a(this);
            this.cvV.setMaxHeight(com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 225.0f));
            this.cvV.setOutsideTouchable(true);
            this.cvV.setFocusable(true);
            this.cvV.setOnDismissListener(this);
            this.cvV.setBackgroundDrawable(com.baidu.tbadk.core.util.ba.getDrawable(com.baidu.tieba.s.cp_bg_line_b));
            int color = com.baidu.tbadk.core.util.ba.getColor(com.baidu.tieba.s.write_text);
            com.baidu.tbadk.core.util.ba.i((View) this.cvU, com.baidu.tieba.u.write_prefix_item_selector);
            com.baidu.tbadk.core.util.ba.c(this.cvW, com.baidu.tieba.u.icon_title_down);
            this.cvU.setTextColor(color);
            for (int i = 0; i < size; i++) {
                TextView textView = new TextView(getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                com.baidu.tbadk.core.util.ba.i((View) textView, com.baidu.tieba.u.write_prefix_item_selector);
                textView.setPadding(com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), getResources().getDimension(com.baidu.tieba.t.ds6)), 0, com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), getResources().getDimension(com.baidu.tieba.t.ds22)), 0);
                this.cvV.addView(textView);
                if (i != size - 1) {
                    layoutParams.bottomMargin = com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), getResources().getDimension(com.baidu.tieba.t.ds6)), 0, com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), getResources().getDimension(com.baidu.tieba.t.ds22)), 0);
                }
            }
            this.cvV.setCurrentIndex(0);
            return;
        }
        this.cvX.setVisibility(8);
    }

    private void arf() {
        if (this.cxz && this.cpU != null) {
            this.cxC.setVisibility(0);
            this.cxB = new s(this);
            this.cxB.jh(this.cpU.getForumName());
            this.cxB.setLoadDataCallBack(new av(this));
        }
    }

    protected void arg() {
        this.cvT.setOnClickListener(new aw(this));
    }

    protected void arh() {
        this.cxF = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cxF.ca(getPageContext().getString(com.baidu.tieba.y.is_save_draft)).ac(false).a(getPageContext().getString(com.baidu.tieba.y.save), new ax(this)).b(getPageContext().getString(com.baidu.tieba.y.not_save), new az(this));
        this.cxF.b(getPageContext());
    }

    protected void aqz() {
        this.cvO = (EditText) findViewById(com.baidu.tieba.v.post_title);
        this.cvO.setOnClickListener(this.cxZ);
        this.cvO.setOnFocusChangeListener(this.cvM);
        if (this.cpU.getType() == 0) {
            if (this.cpU.getTitle() != null) {
                this.cvO.setText(this.cpU.getTitle());
                this.cvO.setSelection(this.cpU.getTitle().length());
            }
        } else if (this.cpU.getType() != 1) {
            this.cpU.getType();
        }
        this.cvO.addTextChangedListener(new ba(this));
    }

    protected void aqB() {
        this.cvS = (EditText) findViewById(com.baidu.tieba.v.post_content);
        this.cvS.setDrawingCacheEnabled(false);
        this.cvS.setOnClickListener(this.cxZ);
        if (this.cpU.getContent() != null && this.cpU.getContent().length() > 0) {
            SpannableString E = TbFaceManager.zr().E(getPageContext().getPageActivity(), this.cpU.getContent());
            this.cvS.setText(E);
            this.cvS.setSelection(E.length());
        } else if (this.cpU.getType() == 2) {
            if (this.cxG) {
                if (this.cxH != null && this.cxH.length() > 0) {
                    this.cvS.setText(getPageContext().getPageActivity().getString(com.baidu.tieba.y.reply_sub_floor, new Object[]{this.cxH}));
                    this.cvS.setSelection(this.cvS.getText().length());
                }
            } else if (this.cpU.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(com.baidu.tieba.y.reply_x_floor), Integer.valueOf(this.cpU.getFloorNum()));
                this.cvS.setText(format);
                this.cvS.setSelection(format.length());
            }
        }
        this.cvS.setOnFocusChangeListener(this.cvM);
        this.cvS.setOnTouchListener(new bb(this));
        this.cvS.addTextChangedListener(new bc(this));
        fk(true);
    }

    public void fk(boolean z) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class)) {
            this.cvS.setPadding(0, 0, 0, 0);
            this.cvS.setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.ba.j((View) this.cvS, com.baidu.tieba.s.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.bzO) && this.cxM == null) {
                com.baidu.adp.lib.f.d.hB().a(this.bzO, 19, new bd(this, z), getUniqueId());
            }
        }
    }

    public boolean Jc() {
        int i = 5000;
        if (this.cxM != null) {
            i = 1000;
        }
        return this.cvS.getText() != null && this.cvS.getText().length() >= i;
    }

    protected void ari() {
        this.cmz = (EditorToolComponetContainer) findViewById(com.baidu.tieba.v.tool_group);
        this.cmz.setFrom(1);
        Boolean arp = arp();
        if (this.cxz || (arp != null && !arp.booleanValue())) {
            this.cmz.zc();
        } else if (this.cpU.getLiveCardData() != null) {
            this.cmz.zb();
        } else {
            this.cmz.za();
        }
        this.cmz.setOnActionListener(new bf(this));
        this.cmz.refresh();
    }

    protected void arj() {
        this.cxK.ale();
        if (this.cmz.alv()) {
            this.cmz.hideAll();
        }
    }

    public void ark() {
        this.cmz.aa(this.cvS);
    }

    public void je(int i) {
        if (this.cmz.alv()) {
            jf(i);
            return;
        }
        this.cmz.Z(this.cvO);
        this.cmz.Z(this.cvS);
        new Handler().postDelayed(new bg(this, i), 200L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.cmz != null) {
            this.cmz.alx();
        }
    }

    public void jf(int i) {
        if (i == 2) {
            this.cxK.apZ();
            this.cmz.alz();
        } else if (i == 5 || i == 60) {
            this.cmz.alA();
        } else if (i == 8) {
            this.cmz.alB();
            this.cxK.aqa();
        } else if (i == 50) {
            this.cmz.alD();
            this.cxK.aqd();
        } else if (i == 44) {
            this.cmz.alC();
            this.cxK.aqb();
        } else if (i == 38) {
            this.cmz.aly();
            this.cxK.aqe();
        } else if (i == 57) {
            this.cmz.alB();
            this.cxK.aqa();
        } else if (i == 48) {
            this.cmz.alD();
        }
    }

    protected void arl() {
        this.cxK = (TbEditorToolButtonContainer) findViewById(com.baidu.tieba.v.write_eidtor_tool_buttons);
        this.cxK.ald();
        this.cxK.setAtFocusable(false);
        this.cxK.setOnActionListener(new bh(this));
        if (TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.cxK.fg(false);
        }
    }

    public void jg(int i) {
        if (this.cmz.alF()) {
            je(i);
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.akV() && this.cxR == 0) {
            showToast(com.baidu.tieba.y.baobao_over_limit);
        } else {
            String charSequence = this.aXK.getText().toString();
            com.baidu.tbadk.core.frameworkData.a aVar = new com.baidu.tbadk.core.frameworkData.a(getPageContext().getPageActivity());
            aVar.getIntent().putExtra("title", charSequence);
            aVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage(2802001, aVar));
        }
    }

    public void a(com.baidu.tbadk.coreExtra.data.f fVar) {
        if (((ImageSpan[]) this.cvS.getText().getSpans(0, this.cvS.getText().length(), ImageSpan.class)).length >= 10) {
            if (this.cxI == null) {
                this.cxI = Toast.makeText(getPageContext().getPageActivity(), com.baidu.tieba.y.too_many_face, 0);
            }
            this.cxI.show();
            return;
        }
        String name = fVar.getName();
        EmotionGroupType uD = fVar.uD();
        if (name != null) {
            com.baidu.adp.lib.f.d.hB().a(name, 20, new bi(this, new SpannableStringBuilder(name), this.cvS.getSelectionStart(), uD), 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap mz = aVar.mz();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(mz);
        int width = mz.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        this.cvS.getText().insert(i, spannableStringBuilder);
    }

    public void arm() {
        this.cvS.onKeyDown(67, this.cxD);
    }

    private void f(Boolean bool) {
        String str = null;
        if (this.cpU != null) {
            str = this.cpU.getForumName();
        }
        if (getPageContext().getString(com.baidu.tieba.y.feedback_bar_name).equals(str)) {
            this.cxz = true;
        }
    }

    private void arn() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void aro() {
        try {
            if (this.cxF != null) {
                this.cxF.dismiss();
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

    private Boolean arp() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.bHS = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void aqA() {
        String str = null;
        if (this.cpU.getType() == 0) {
            String trim = this.cvO.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                if (this.cvx == this.mPrefixData.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.cpU.setIsNoTitle(true);
                    } else {
                        this.cpU.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.cpU.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.cpU.setIsNoTitle(true);
            } else {
                this.cpU.setIsNoTitle(false);
                str = "1";
            }
        }
        String trim2 = this.cvS.getText().toString().trim();
        if (this.cmz.alE()) {
            str = "1";
        } else if (!TextUtils.isEmpty(trim2)) {
            str = "1";
        } else if (this.cmz.alG()) {
            str = "1";
        } else if (this.cmz.alF()) {
            str = "1";
        }
        if (str == null || str.length() <= 0) {
            this.cvT.setEnabled(false);
        } else {
            this.cvT.setEnabled(true);
        }
    }

    private void initData(Bundle bundle) {
        this.aHC = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aHC.a(this.bIk);
        registerListener(this.cxW);
        this.ccA = new bj(this);
        this.cpU = new WriteData();
        if (bundle != null) {
            this.cpU.setType(bundle.getInt("type", 0));
            this.cpU.setForumId(bundle.getString("forum_id"));
            this.cpU.setForumName(bundle.getString("forum_name"));
            this.cpU.setThreadId(bundle.getString("thread_id"));
            this.cpU.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.cpU.setFloorNum(bundle.getInt(WriteActivityConfig.FLOOR_NUM, 0));
            this.cxz = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.cxG = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.cxH = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.aHA = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.cxM = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.cpU.setIsAddition(this.cxM != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.cxR = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
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
                this.cpU.setLiveCardData(liveCardData);
            }
        } else {
            Intent intent = getIntent();
            this.cpU.setType(intent.getIntExtra("type", 0));
            this.cpU.setForumId(intent.getStringExtra("forum_id"));
            this.cpU.setForumName(intent.getStringExtra("forum_name"));
            this.cpU.setThreadId(intent.getStringExtra("thread_id"));
            this.cpU.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.cpU.setFloorNum(intent.getIntExtra(WriteActivityConfig.FLOOR_NUM, 0));
            this.cxz = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.cxG = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.cxH = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.cxM = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.cpU.setIsAddition(this.cxM != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.cxR = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
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
                this.cpU.setLiveCardData(liveCardData2);
            }
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(10);
        this.cpU.setWriteImagesInfo(this.writeImagesInfo);
        this.cpU.setBaobaoImagesInfo(this.baobaoImagesInfo);
        if (this.cpU.getType() == 0) {
            if (this.cpU.getLiveCardData() == null) {
                com.baidu.tieba.tbadkCore.ao.b(this.cpU.getForumId(), this);
            } else {
                com.baidu.tieba.tbadkCore.ao.a(this.cpU.getLiveCardData().getGroupId(), this);
            }
        } else if (this.cpU.getType() == 1) {
            com.baidu.tieba.tbadkCore.ao.a(this.cpU.getThreadId(), this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(com.baidu.tieba.y.write_no_prefix));
        }
        this.bzO = TbadkCoreApplication.m411getInst().getDefaultBubble();
        if (this.cpU != null && this.cpU.getForumName() != null && TbadkCoreApplication.m411getInst().getYijianfankuiFname() != null && this.cpU.getForumName().equals(TbadkCoreApplication.m411getInst().getYijianfankuiFname())) {
            this.cxA = true;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ap
    public void a(WriteData writeData) {
        if (writeData != null && this.cpU != null) {
            this.cpU.setHaveDraft(true);
            if (com.baidu.adp.lib.util.m.isEmpty(this.cvO.getText().toString()) || ((this.cxz || this.cxA) && !com.baidu.adp.lib.util.m.isEmpty(writeData.getTitle()))) {
                this.cpU.setTitle(writeData.getTitle());
                this.cvO.setText(this.cpU.getTitle());
                this.cvO.setSelection(this.cpU.getTitle().length());
            }
            if (writeData.getLiveCardData() != null) {
                Date date = new Date(writeData.getLiveCardData().getStartTime() * 1000);
                Date date2 = new Date();
                date.setYear(date2.getYear());
                date.setMonth(date2.getMonth());
                date.setDate(date2.getDate());
                this.cpU.getLiveCardData().setStartTime(date.getTime() / 1000);
                this.cxT.setText(com.baidu.tbadk.core.util.bd.o(this.cpU.getLiveCardData().getStartTime() * 1000));
            }
            if ((com.baidu.adp.lib.util.m.isEmpty(this.cvS.getText().toString()) || this.cxz || this.cxA) && !com.baidu.adp.lib.util.m.isEmpty(writeData.getContent())) {
                this.cpU.setContent(writeData.getContent());
                SpannableString a = TbFaceManager.zr().a(getPageContext().getPageActivity(), this.cpU.getContent(), new bk(this));
                this.cvS.setText(a);
                this.cvS.setSelection(a.length());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo = writeData.getWriteImagesInfo();
                this.cpU.setWriteImagesInfo(this.writeImagesInfo);
                this.cmz.a(this.writeImagesInfo, true);
                fl(false);
            }
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen()) {
                if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                    this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                    this.cpU.setIsBaobao(writeData.getIsBaobao());
                    this.cpU.setBaobaoContent(writeData.getBaobaoContent());
                    this.cpU.setBaobaoImagesInfo(this.baobaoImagesInfo);
                }
                if (this.cpU.getIsBaobao()) {
                    this.cmz.setBaobaoUris(this.baobaoImagesInfo);
                    fm(false);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.cpU.getType());
        bundle.putString("forum_id", this.cpU.getForumId());
        bundle.putString("forum_name", this.cpU.getForumName());
        bundle.putString("thread_id", this.cpU.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.cpU.getFloor());
        bundle.putInt(WriteActivityConfig.FLOOR_NUM, this.cpU.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.cxG);
        if (this.cxz) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aHA);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.cxM);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.cxR);
        if (this.cpU.getLiveCardData() != null) {
            bundle.putBoolean(WriteActivityConfig.IS_LIVE_POST, true);
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ID, this.cpU.getLiveCardData().getGroupId());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_HEAD, this.cpU.getLiveCardData().getPortrait());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_INTRO, this.cpU.getLiveCardData().getIntro());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_NAME, this.cpU.getLiveCardData().getName());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, this.cpU.getLiveCardData().getListeners());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, this.cpU.getLiveCardData().getLikers());
            bundle.putLong(WriteActivityConfig.LIVE_DATE, this.cpU.getLiveCardData().getStartTime());
            bundle.putBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY, this.cpU.getLiveCardData().isModifyTime());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD, this.cpU.getLiveCardData().getPublisherPortrait());
        }
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = this.cvS.getEditableText().toString();
        if (editable != null) {
            this.cvS.setText(TbFaceManager.zr().E(getPageContext().getPageActivity(), editable));
            this.cvS.setSelection(this.cvS.getText().length());
        }
    }

    public void aqv() {
        aqs();
        if (this.cpU.getLiveCardData() != null) {
            if (!this.cpU.getLiveCardData().isModifyTime()) {
                this.cpU.getLiveCardData().setStartTime(new Date().getTime() / 1000);
                this.cxT.setText(com.baidu.tbadk.core.util.bd.o(this.cpU.getLiveCardData().getStartTime() * 1000));
            }
            long time = new Date().getTime() / TbConfig.USE_TIME_INTERVAL;
            Date date = new Date(this.cpU.getLiveCardData().getStartTime() * 1000);
            Date date2 = new Date();
            date.setYear(date2.getYear());
            date.setMonth(date2.getMonth());
            date.setDate(date2.getDate());
            this.cpU.getLiveCardData().setStartTime(date.getTime() / 1000);
            if (time > this.cpU.getLiveCardData().getStartTime() / 60) {
                showToast(com.baidu.tieba.y.live_start_time_error);
                return;
            }
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.cvx != this.mPrefixData.getPrefixs().size() - 1) {
            this.cpU.setTitle(String.valueOf(this.cvU.getText().toString()) + this.cvO.getText().toString());
        } else {
            this.cpU.setTitle(this.cvO.getText().toString());
        }
        this.cpU.setContent(this.cvS.getText().toString());
        if (this.cxz || this.cxA) {
            String string = getResources().getString(com.baidu.tieba.y.android_feedback);
            if (TextUtils.isEmpty(this.cpU.getTitle()) || !this.cpU.getTitle().startsWith(string)) {
                this.cpU.setTitle(string + this.cpU.getTitle());
            }
            String str = String.valueOf(getResources().getString(com.baidu.tieba.y.app_name)) + getResources().getString(com.baidu.tieba.y.tieba_client);
            if (TextUtils.isEmpty(this.cpU.getContent()) || !this.cpU.getContent().startsWith(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(TbConfig.getVersion());
                sb.append(", ");
                sb.append(Build.VERSION.RELEASE);
                sb.append(", ");
                sb.append(Build.MODEL);
                sb.append(", ");
                if (com.baidu.adp.lib.util.k.iH()) {
                    sb.append(com.baidu.adp.lib.util.k.iO());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.cpU.getContent());
                this.cpU.setContent(sb.toString());
            }
        }
        this.cpU.setWriteImagesInfo(this.writeImagesInfo);
        this.cpU.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.cpU.setHasLocationData(this.cxJ.getLocationInfoViewState() == 2);
        this.aHC.eS(this.writeImagesInfo.size() > 0);
        this.aHC.c(this.cpU);
        VoiceData.VoiceModel audioData = this.cmz.getAudioData();
        this.cmz.Jh();
        this.cpU.setVcode(null);
        if (audioData != null) {
            if (audioData.getId() != null) {
                this.aHC.IM().setVoice(audioData.getId());
                this.aHC.IM().setVoiceDuringTime(audioData.duration);
            } else {
                this.aHC.IM().setVoice(null);
                this.aHC.IM().setVoiceDuringTime(-1);
            }
        } else {
            this.aHC.IM().setVoice(null);
            this.aHC.IM().setVoiceDuringTime(-1);
        }
        if (!this.aHC.anC()) {
            showToast(com.baidu.tieba.y.write_img_limit);
        } else if (this.aHC.anA()) {
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.y.sending), this.ccA);
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
            if (this.cxM != null) {
                i2 = this.cxM.getTotalCount();
                i = this.cxM.getAlreadyCount() + 1;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 > i) {
                sb.append("\n").append(String.format(getPageContext().getString(com.baidu.tieba.y.write_addition_left_count), Integer.valueOf(i2 - i)));
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
                ArrayList<String> V = com.baidu.tieba.tbadkCore.util.i.V(intent);
                if (V != null && V.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = i3;
                        if (i4 < V.size()) {
                            sb.append("@");
                            sb.append(V.get(i4));
                            sb.append(" ");
                            i3 = i4 + 1;
                        } else {
                            String sb2 = sb.toString();
                            this.cvS.getText().insert(this.cvS.getSelectionStart(), sb2);
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                if (this.cpU.getType() == 0) {
                    com.baidu.tieba.tbadkCore.ao.a(this.cpU.getForumId(), (WriteData) null);
                } else if (this.cpU.getType() == 1) {
                    com.baidu.tieba.tbadkCore.ao.b(this.cpU.getThreadId(), (WriteData) null);
                }
                setResult(-1, intent);
                finish();
            } else if (i == 12002) {
                if (intent != null) {
                    if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                        aa(intent);
                    } else {
                        Z(intent);
                    }
                }
            } else if (i == 12012) {
                K(intent);
                aqA();
            } else if (i == 12013) {
                T(intent);
                aqA();
            } else if (i == 23004) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    IN();
                    return;
                case 12002:
                    if (!this.cmz.alE()) {
                        arj();
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
                    this.aHA = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.az.a(getPageContext(), this.aHA);
                    return;
                default:
                    return;
            }
        }
    }

    private void Z(Intent intent) {
        Q(intent);
        aqA();
        this.cmz.setVisibility(0);
    }

    private void aa(Intent intent) {
        int size;
        L(intent);
        int size2 = this.writeImagesInfo.size() - 1;
        if (size2 > -1 && this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), 12012, this.writeImagesInfo, size2)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, this.cvO);
        HidenSoftKeyPad(this.mInputManager, this.cvS);
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void Q(Intent intent) {
        b(intent, true);
    }

    public boolean arq() {
        boolean alG = this.cmz.alG();
        LinkedList<ImageFileInfo> chosedFiles = this.baobaoImagesInfo.getChosedFiles();
        return !alG && (chosedFiles == null || chosedFiles.isEmpty());
    }

    private void L(Intent intent) {
        this.aHA = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aHA;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cf = com.baidu.tbadk.core.util.c.cf(str);
                if (cf != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.c.h(b, cf);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.o.a(TbConfig.LOCAL_CAMERA_DIR, this.aHA, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            this.cmz.a(this.writeImagesInfo, true);
        }
        fl(true);
    }

    private void K(Intent intent) {
        b(intent, false);
    }

    private void b(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    this.cmz.a(this.writeImagesInfo, z);
                }
            }
            fl(true);
        }
    }

    private void T(Intent intent) {
        if (this.cpU != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.cpU.setIsBaobao(true);
            this.cpU.setBaobaoContent(stringExtra2);
            this.cmz.setBaobaoUris(this.baobaoImagesInfo);
            fm(true);
        }
    }

    private void IN() {
        new bl(this).execute(new Void[0]);
    }

    private void fl(boolean z) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.cxK.ei(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            this.cxL = true;
            this.cmz.ei(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            if (this.cmz.alv() || z) {
                this.cmz.alB();
                return;
            }
            return;
        }
        this.cxK.yP();
        this.cxL = false;
        this.cmz.yP();
        if (this.cmz.alG()) {
            this.cmz.yX();
            this.cxK.amc();
        }
        arj();
    }

    private void fm(boolean z) {
        LinkedList<ImageFileInfo> chosedFiles = this.baobaoImagesInfo.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.cxK.aqd();
            this.cxK.amc();
            if (this.cmz.alv() || z) {
                this.cmz.alD();
            }
            this.cpU.setIsBaobao(true);
            return;
        }
        if (arq()) {
            this.cxK.amd();
        }
        this.cpU.setIsBaobao(false);
        this.cxK.aqc();
        arj();
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
            antiData.setBlock_forum_name(this.cpU.getForumName());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.WRITE);
        } else if (this.cxM == null) {
            com.baidu.tieba.tbadkCore.writeModel.h.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        } else {
            l(z, str);
        }
    }

    public void a(boolean z, AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.cpU.getForumName());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.WRITE);
        } else if (this.cxM == null) {
            com.baidu.tieba.tbadkCore.writeModel.h.L(getPageContext().getPageActivity(), str);
        } else {
            l(z, str);
        }
    }

    @Override // com.baidu.tieba.write.write.cn
    public void iW(int i) {
        this.cvx = i;
        this.cvV.setCurrentIndex(i);
        this.cvU.setText(this.mPrefixData.getPrefixs().get(i));
        aqA();
        com.baidu.adp.lib.g.k.a(this.cvV, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.cvX.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
