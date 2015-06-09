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
    private com.baidu.tieba.tbadkCore.location.e aJN;
    private String aJS;
    private com.baidu.tieba.tbadkCore.writeModel.a aJU;
    private TextView cAB;
    private cn cAC;
    private ImageView cAD;
    private View cAE;
    private int cAe;
    private AdditionData cCA;
    private RelativeLayout cCB;
    private TextView cCC;
    private TextView cCD;
    private TextView cCE;
    private RelativeLayout cCG;
    private TextView cCH;
    private View cCI;
    private LiveBroadcastCard cCJ;
    private com.baidu.tieba.view.a cCP;
    private View cCp;
    private Toast cCw;
    private GestureDetector mGestureDetector;
    private PostPrefixData mPrefixData;
    private VoiceManager mVoiceManager;
    private WriteData cup = null;
    private boolean cCl = false;
    private boolean cCm = false;
    private InputMethodManager mInputManager = null;
    private EditText cAv = null;
    private View cAw = null;
    private LinearLayout cAy = null;
    private EditText cAz = null;
    private t cCn = null;
    private FeedBackTopListView cCo = null;
    private ArrayList<com.baidu.tieba.write.view.j> cCq = new ArrayList<>();
    private String bCQ = null;
    private final KeyEvent cCr = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView cCs = null;
    private TextView cAA = null;
    private TextView baI = null;
    private DialogInterface.OnCancelListener bSJ = null;
    private com.baidu.tbadk.core.dialog.a cCt = null;
    private final Handler mHandler = new Handler();
    private boolean cCu = false;
    private String cCv = null;
    private RelativeLayout aZK = null;
    private String bKv = null;
    private com.baidu.tieba.write.editor.b cCx = null;
    private TbEditorToolButtonContainer cCy = null;
    private EditorToolComponetContainer cqP = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private WriteImagesInfo baobaoImagesInfo = new WriteImagesInfo();
    private boolean cCz = false;
    private int cCF = 0;
    private final HttpMessageListener cCK = new ai(this, CmdConfigHttp.REQUEST_BUBBLELIST_CMD);
    private final com.baidu.tieba.tbadkCore.writeModel.e bKK = new at(this);
    private final com.baidu.tieba.tbadkCore.location.j aJY = new bf(this);
    private final View.OnClickListener cCL = new bn(this);
    private final CustomMessageListener ctM = new bo(this, 2001232);
    private final Runnable cCM = new bp(this);
    private final View.OnClickListener cCN = new bq(this);
    private boolean cCO = true;
    private final View.OnFocusChangeListener cAt = new br(this);
    private final CustomMessageListener cqT = new bs(this, 2001310);
    private final com.baidu.tieba.tbadkCore.c.h bOA = new aj(this);

    public void JP() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void JQ() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(com.baidu.tieba.t.location_system_permission_prompt);
            this.cCx.setLocationInfoViewState(0);
        } else if (!TbadkCoreApplication.m411getInst().getLocationShared()) {
            JR();
        } else if (this.aJN.apn()) {
            JP();
        } else {
            this.aJN.fi(false);
            this.cCx.setLocationInfoViewState(1);
            this.aJN.apl();
        }
    }

    private void JR() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bu(com.baidu.tieba.t.location_app_permission_prompt).a(com.baidu.tieba.t.isopen, new ak(this)).b(com.baidu.tieba.t.cancel, new al(this)).b(getPageContext());
        aVar.rL();
    }

    public int atf() {
        int selectionEnd = this.cAz.getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) this.cAz.getText().getSpans(0, this.cAz.getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = this.cAz.getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = this.cAz.getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    public void atg() {
        if (!this.cCO) {
            this.cCy.and();
        } else {
            this.cCy.ane();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        this.cqP.anM();
        if (this.cCP != null && this.cup != null && this.cup.getLiveCardData() != null) {
            new Handler().postDelayed(new am(this, new Date(this.cup.getLiveCardData().getStartTime() * 1000)), 100L);
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
        this.cqP.anK();
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
        atl();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.cqT.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.cqT);
        this.aJN = new com.baidu.tieba.tbadkCore.location.e(this);
        this.aJN.a(this.aJY);
        registerListener(this.ctM);
        if (this.cCA == null) {
            JS();
        }
        this.cAz.requestFocus();
    }

    public void anW() {
        boolean appResponseToCmd = TbadkCoreApplication.m411getInst().appResponseToCmd(2802001);
        if (!TbadkCoreApplication.m411getInst().isBaobaoShouldOpen() || this.cCA != null || !appResponseToCmd) {
            this.cCy.asm();
        }
    }

    private void JS() {
        if (this.aJN.app()) {
            if (this.aJN.apn()) {
                this.cCx.D(2, com.baidu.tieba.tbadkCore.location.d.api().getLocationData().ape());
                return;
            }
            this.cCx.setLocationInfoViewState(1);
            this.aJN.apl();
            return;
        }
        this.cCx.setLocationInfoViewState(0);
    }

    public void asy() {
        if (this.aJU != null) {
            this.aJU.cancelLoadData();
        }
        if (this.cCn != null) {
            this.cCn.cancelLoadData();
        }
        if (this.aJN != null) {
            this.aJN.cancelLoadData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        TiebaPrepareImageService.StopService();
        asy();
        atu();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
    }

    public void ath() {
        if (this.cup != null && this.cup.getType() == 2 && this.cCu) {
            finish();
        } else if (this.cup == null) {
            finish();
        } else {
            this.cup.setTitle(this.cAv.getText().toString());
            this.cup.setContent(this.cAz.getText().toString());
            int type = this.cup.getType();
            if (this.cup.getHaveDraft() && com.baidu.adp.lib.util.m.isEmpty(this.cup.getTitle()) && com.baidu.adp.lib.util.m.isEmpty(this.cup.getContent()) && !this.cup.isHasImages()) {
                if (type == 0) {
                    if (this.cup.getLiveCardData() == null) {
                        com.baidu.tieba.tbadkCore.ao.a(this.cup.getForumId(), (WriteData) null);
                    } else {
                        com.baidu.tieba.tbadkCore.ao.a(this.cup.getLiveCardData().getGroupId(), (WriteData) null);
                    }
                } else if (type == 1) {
                    com.baidu.tieba.tbadkCore.ao.b(this.cup.getThreadId(), (WriteData) null);
                }
            } else if (type == 0) {
                if (this.cup.getLiveCardData() == null) {
                    com.baidu.tieba.tbadkCore.ao.a(this.cup.getForumId(), this.cup);
                } else {
                    com.baidu.tieba.tbadkCore.ao.a(this.cup.getLiveCardData().getGroupId(), this.cup);
                }
            } else if (type == 1) {
                com.baidu.tieba.tbadkCore.ao.b(this.cup.getThreadId(), this.cup);
            }
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.cAC != null && this.cAC.isShowing()) {
                com.baidu.adp.lib.g.k.a(this.cAC, getPageContext().getPageActivity());
                return true;
            } else if (this.cqP.anx()) {
                this.cCy.anf();
                this.cqP.hideAll();
                return true;
            } else {
                asy();
                ath();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(this.aZK);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        com.baidu.tbadk.core.util.ay.g(this.cAA, i);
        atg();
        com.baidu.tbadk.core.util.ay.j(this.cAw, com.baidu.tieba.n.cp_bg_line_c);
        com.baidu.tbadk.core.util.ay.j((View) this.cAv, com.baidu.tieba.n.cp_bg_line_d);
        if (TextUtils.isEmpty(this.bCQ)) {
            com.baidu.tbadk.core.util.ay.j((View) this.cAz, com.baidu.tieba.n.cp_bg_line_d);
        }
        int color = com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.cp_cont_b);
        int color2 = com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.cp_cont_e);
        this.cCy.changeSkinType(i);
        this.cAv.setTextColor(color);
        this.cAz.setTextColor(color);
        a(this.cAv, color2);
        a(this.cAz, color2);
        asG();
        this.cqP.onChangeSkinType(i);
        this.cCx.rU();
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
        this.baI = this.mNavigationBar.setTitleText("");
        this.cCs = (TextView) findViewById(com.baidu.tieba.q.btn_image_problem);
        this.cAA = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.t.send_post));
        this.cAA.setOnFocusChangeListener(this.cAt);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.cCo = (FeedBackTopListView) findViewById(com.baidu.tieba.q.feedback_top_list);
        this.aZK = (RelativeLayout) findViewById(com.baidu.tieba.q.parent);
        this.cAw = findViewById(com.baidu.tieba.q.interval_view);
        asF();
        asH();
        if (this.cCl || this.cCm) {
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
        this.cAy = (LinearLayout) findViewById(com.baidu.tieba.q.post_content_container);
        this.cAy.setDrawingCacheEnabled(false);
        this.cAy.setOnClickListener(new an(this));
        this.mBack.setOnFocusChangeListener(this.cAt);
        this.mBack.setOnClickListener(new ao(this));
        this.cCs.setOnClickListener(new ap(this));
        this.cCx = new com.baidu.tieba.write.editor.b((EditorInfoContainer) findViewById(com.baidu.tieba.q.write_editor_info));
        this.cCx.A(this.cCL);
        if (this.cCA != null) {
            this.cCx.destroy();
        }
        f(atv());
        atj();
        atr();
        ato();
        atm();
        anW();
        if (this.cup.getType() == 0) {
            if (this.cCl || this.cCm) {
                this.cCy.asm();
                this.baI.setText(com.baidu.tieba.t.feedback);
            } else {
                this.baI.setText(com.baidu.tieba.t.post_new_thread);
            }
            this.cAv.setVisibility(0);
            this.cAz.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
        } else {
            this.baI.setText(com.baidu.tieba.t.send_reply);
            this.cAz.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
            this.cAv.setVisibility(8);
        }
        atn();
        att();
        atg();
        atk();
        asE();
        asG();
        if (this.cup.getLiveCardData() == null) {
            ShowSoftKeyPad(this.mInputManager, this.cAv);
        }
        ati();
    }

    private void ati() {
        if (this.cqP != null) {
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            this.cqP.setShadowHeight(getResources().getDimensionPixelSize(com.baidu.tieba.o.ds1));
            if (skinType == 1) {
                this.cqP.setShadowBackground(com.baidu.tieba.n.cp_bg_line_b_1);
            } else {
                this.cqP.setShadowBackground(com.baidu.tieba.n.cp_cont_e);
            }
        }
    }

    private void atj() {
        this.cCG = (RelativeLayout) findViewById(com.baidu.tieba.q.live_time_rel);
        this.cCH = (TextView) findViewById(com.baidu.tieba.q.live_tiem_show);
        this.cCI = findViewById(com.baidu.tieba.q.interval_view2);
        this.cCJ = (LiveBroadcastCard) findViewById(com.baidu.tieba.q.live_anchor_card);
        this.cCG.setOnClickListener(new aq(this));
        this.cCG.setOnTouchListener(new ar(this));
        if (this.cup.getLiveCardData() != null) {
            this.cCG.setVisibility(0);
            this.cCI.setVisibility(0);
            this.cCJ.setVisibility(0);
            this.cCJ.setClickable(false);
            this.cCH.setText(com.baidu.tbadk.core.util.bb.p(this.cup.getLiveCardData().getStartTime() * 1000));
            this.cCJ.setData(this.cup.getLiveCardData());
            return;
        }
        this.cCG.setVisibility(8);
        this.cCI.setVisibility(8);
        this.cCJ.setVisibility(8);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
        if ((dialog instanceof com.baidu.tieba.view.a) && this.cup.getLiveCardData() != null) {
            Date date = new Date(this.cup.getLiveCardData().getStartTime() * 1000);
            ((com.baidu.tieba.view.a) dialog).updateTime(date.getHours(), date.getMinutes());
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.cCP = new com.baidu.tieba.view.a(getPageContext().getPageActivity(), new as(this), new Date().getHours(), new Date().getMinutes(), false);
        this.cCP.setTitle(com.baidu.tieba.t.no_disturb_start_time);
        this.cCP.setButton(-1, getPageContext().getString(com.baidu.tieba.t.alert_yes_button), this.cCP);
        this.cCP.setButton(-2, getPageContext().getString(com.baidu.tieba.t.alert_no_button), this.cCP);
        return this.cCP;
    }

    private void atk() {
        this.cCB = (RelativeLayout) findViewById(com.baidu.tieba.q.addition_container);
        this.cCC = (TextView) findViewById(com.baidu.tieba.q.addition_create_time);
        this.cCD = (TextView) findViewById(com.baidu.tieba.q.addition_last_time);
        this.cCE = (TextView) findViewById(com.baidu.tieba.q.addition_last_content);
        if (this.cCA != null) {
            this.cCB.setVisibility(0);
            this.cCC.setText(String.valueOf(getPageContext().getString(com.baidu.tieba.t.write_addition_create)) + com.baidu.tbadk.core.util.bb.o(this.cCA.getCreateTime() * 1000));
            if (this.cCA.getAlreadyCount() == 0) {
                this.cCD.setVisibility(8);
            } else {
                this.cCD.setText(String.valueOf(getPageContext().getString(com.baidu.tieba.t.write_addition_last)) + com.baidu.tbadk.core.util.bb.o(this.cCA.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.cCA.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.cCE.setText(lastAdditionContent);
            } else {
                this.cCE.setVisibility(8);
            }
            this.cAz.setHint(String.format(getPageContext().getString(com.baidu.tieba.t.write_addition_hint), Integer.valueOf(this.cCA.getAlreadyCount()), Integer.valueOf(this.cCA.getTotalCount())));
            this.baI.setText(com.baidu.tieba.t.write_addition_title);
            return;
        }
        this.cCB.setVisibility(8);
    }

    private void asE() {
        this.cAE = findViewById(com.baidu.tieba.q.post_prefix_layout);
        this.cAB = (TextView) findViewById(com.baidu.tieba.q.post_prefix);
        this.cCp = findViewById(com.baidu.tieba.q.prefix_divider);
        this.cAD = (ImageView) findViewById(com.baidu.tieba.q.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.cAE.setVisibility(0);
            this.cCp.setVisibility(0);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.cAe = 1;
            this.cAE.setOnClickListener(new au(this));
            this.cAD = (ImageView) findViewById(com.baidu.tieba.q.prefix_icon);
            if (size > 1) {
                this.cAD.setVisibility(0);
                this.cAB.setOnClickListener(new av(this));
            }
            this.cAC = new cn(getPageContext().getPageActivity());
            this.cAC.a(this);
            this.cAC.setMaxHeight(com.baidu.adp.lib.util.n.d(getActivity(), com.baidu.tieba.o.ds510));
            this.cAC.setOutsideTouchable(true);
            this.cAC.setFocusable(true);
            this.cAC.setOnDismissListener(this);
            this.cAC.setBackgroundDrawable(com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.n.cp_bg_line_d));
            int color = com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.write_text);
            int color2 = com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.cp_cont_c);
            com.baidu.tbadk.core.util.ay.i((View) this.cAB, com.baidu.tieba.n.cp_bg_line_d);
            com.baidu.tbadk.core.util.ay.c(this.cAD, com.baidu.tieba.p.icon_title_down);
            this.cAB.setTextColor(color);
            this.cCq.clear();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.write.view.j jVar = new com.baidu.tieba.write.view.j(getActivity());
                this.cCq.add(jVar);
                jVar.setPrefixText(prefixs.get(i));
                if (i == 0) {
                    jVar.setPrefixTextColor(color2);
                } else {
                    jVar.setPrefixTextColor(color);
                }
                if (i != size - 1) {
                    jVar.setDividerStyle(false);
                }
                this.cAC.addView(jVar);
            }
            this.cAC.setCurrentIndex(0);
            this.cAB.setText(prefixs.get(1));
            jG(1);
            return;
        }
        this.cAE.setVisibility(8);
    }

    private void atl() {
        if (this.cCl && this.cup != null) {
            this.cCo.setVisibility(0);
            this.cCn = new t(this);
            this.cCn.kd(this.cup.getForumName());
            this.cCn.setLoadDataCallBack(new aw(this));
        }
    }

    protected void atm() {
        this.cAA.setOnClickListener(new ax(this));
    }

    protected void atn() {
        this.cCt = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cCt.cn(getPageContext().getString(com.baidu.tieba.t.is_save_draft)).ag(false).a(getPageContext().getString(com.baidu.tieba.t.save), new ay(this)).b(getPageContext().getString(com.baidu.tieba.t.not_save), new ba(this));
        this.cCt.b(getPageContext());
    }

    protected void asF() {
        this.cAv = (EditText) findViewById(com.baidu.tieba.q.post_title);
        this.cAv.setOnClickListener(this.cCN);
        this.cAv.setOnFocusChangeListener(this.cAt);
        if (this.cup.getType() == 0) {
            if (this.cup.getTitle() != null) {
                this.cAv.setText(this.cup.getTitle());
                this.cAv.setSelection(this.cup.getTitle().length());
            }
        } else if (this.cup.getType() != 1) {
            this.cup.getType();
        }
        this.cAv.addTextChangedListener(new bb(this));
    }

    protected void asH() {
        this.cAz = (EditText) findViewById(com.baidu.tieba.q.post_content);
        this.cAz.setDrawingCacheEnabled(false);
        this.cAz.setOnClickListener(this.cCN);
        if (this.cup.getContent() != null && this.cup.getContent().length() > 0) {
            SpannableString F = TbFaceManager.Al().F(getPageContext().getPageActivity(), this.cup.getContent());
            this.cAz.setText(F);
            this.cAz.setSelection(F.length());
        } else if (this.cup.getType() == 2) {
            if (this.cCu) {
                if (this.cCv != null && this.cCv.length() > 0) {
                    this.cAz.setText(getPageContext().getPageActivity().getString(com.baidu.tieba.t.reply_sub_floor, new Object[]{this.cCv}));
                    this.cAz.setSelection(this.cAz.getText().length());
                }
            } else if (this.cup.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(com.baidu.tieba.t.reply_x_floor), Integer.valueOf(this.cup.getFloorNum()));
                this.cAz.setText(format);
                this.cAz.setSelection(format.length());
            }
        }
        this.cAz.setOnFocusChangeListener(this.cAt);
        this.cAz.setOnTouchListener(new bc(this));
        this.cAz.addTextChangedListener(new bd(this));
        fF(true);
    }

    public void fF(boolean z) {
        if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class)) {
            this.cAz.setPadding(0, 0, 0, 0);
            this.cAz.setBackgroundDrawable(null);
            com.baidu.tbadk.core.util.ay.j((View) this.cAz, com.baidu.tieba.n.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.bCQ) && this.cCA == null) {
                com.baidu.adp.lib.f.d.hl().a(this.bCQ, 19, new be(this, z), getUniqueId());
            }
        }
    }

    public boolean Kn() {
        int i = 5000;
        if (this.cCA != null) {
            i = 1000;
        }
        return this.cAz.getText() != null && this.cAz.getText().length() >= i;
    }

    protected void ato() {
        this.cqP = (EditorToolComponetContainer) findViewById(com.baidu.tieba.q.tool_group);
        this.cqP.setFrom(1);
        Boolean atv = atv();
        if (this.cCl || (atv != null && !atv.booleanValue())) {
            this.cqP.zW();
        } else if (this.cup.getLiveCardData() != null) {
            this.cqP.zV();
        } else {
            this.cqP.zU();
        }
        if (!StringUtils.isNull(this.bKv)) {
            this.cqP.setAudioCanUse(false);
        }
        this.cqP.setOnActionListener(new bg(this));
        this.cqP.refresh();
    }

    protected void atp() {
        this.cCy.anf();
        if (this.cqP.anx()) {
            this.cqP.hideAll();
        }
    }

    public void atq() {
        this.cqP.ab(this.cAz);
    }

    public void jD(int i) {
        if (this.cqP.anx()) {
            jE(i);
            return;
        }
        this.cqP.aa(this.cAv);
        this.cqP.aa(this.cAz);
        new Handler().postDelayed(new bh(this, i), 200L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardHeightChanged(int i) {
        super.onKeyboardHeightChanged(i);
        if (this.cqP != null) {
            this.cqP.anz();
        }
    }

    public void jE(int i) {
        if (i == 2) {
            this.cCy.asf();
            this.cqP.anB();
        } else if (i == 5 || i == 60) {
            this.cqP.anC();
        } else if (i == 8) {
            this.cqP.anD();
            this.cCy.asg();
        } else if (i == 50) {
            this.cqP.anF();
            this.cCy.asj();
        } else if (i == 44) {
            this.cqP.anE();
            this.cCy.ash();
        } else if (i == 38) {
            this.cqP.anA();
            this.cCy.ask();
        } else if (i == 57) {
            this.cqP.anD();
            this.cCy.asg();
        } else if (i == 48) {
            this.cqP.anF();
        }
    }

    protected void atr() {
        this.cCy = (TbEditorToolButtonContainer) findViewById(com.baidu.tieba.q.write_eidtor_tool_buttons);
        this.cCy.ane();
        this.cCy.setAtFocusable(false);
        this.cCy.setOnActionListener(new bi(this));
        if (TbadkCoreApplication.m411getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            this.cCy.fA(false);
        }
    }

    public void jF(int i) {
        if (this.cqP.anH()) {
            jD(i);
        } else if (!com.baidu.tieba.tbadkCore.PbEditor.a.amW() && this.cCF == 0) {
            showToast(com.baidu.tieba.t.baobao_over_limit);
        } else {
            String charSequence = this.baI.getText().toString();
            com.baidu.tbadk.core.frameworkData.c cVar = new com.baidu.tbadk.core.frameworkData.c(getPageContext().getPageActivity());
            cVar.getIntent().putExtra("title", charSequence);
            cVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            sendMessage(new CustomMessage(2802001, cVar));
        }
    }

    public void a(com.baidu.tbadk.coreExtra.data.f fVar) {
        if (((ImageSpan[]) this.cAz.getText().getSpans(0, this.cAz.getText().length(), ImageSpan.class)).length >= 10) {
            if (this.cCw == null) {
                this.cCw = Toast.makeText(getPageContext().getPageActivity(), com.baidu.tieba.t.too_many_face, 0);
            }
            this.cCw.show();
            return;
        }
        String name = fVar.getName();
        EmotionGroupType vm = fVar.vm();
        if (name != null) {
            com.baidu.adp.lib.f.d.hl().a(name, 20, new bj(this, new SpannableStringBuilder(name), this.cAz.getSelectionStart(), vm), 0, 0, getUniqueId(), null, name, false, null);
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
        this.cAz.getText().insert(i, spannableStringBuilder);
    }

    public void ats() {
        this.cAz.onKeyDown(67, this.cCr);
    }

    private void f(Boolean bool) {
        String str = null;
        if (this.cup != null) {
            str = this.cup.getForumName();
        }
        if (getPageContext().getString(com.baidu.tieba.t.feedback_bar_name).equals(str)) {
            this.cCl = true;
        }
    }

    private void att() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void atu() {
        try {
            if (this.cCt != null) {
                this.cCt.dismiss();
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

    private Boolean atv() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.bKv = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    public void asG() {
        String str = null;
        if (this.cup.getType() == 0) {
            String trim = this.cAv.getText().toString().trim();
            if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                this.mPrefixData.getPrefixs();
                if (this.cAe == 0) {
                    if (TextUtils.isEmpty(trim)) {
                        this.cup.setIsNoTitle(true);
                    } else {
                        this.cup.setIsNoTitle(false);
                        str = "1";
                    }
                } else {
                    this.cup.setIsNoTitle(false);
                    str = "1";
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.cup.setIsNoTitle(true);
            } else {
                this.cup.setIsNoTitle(false);
                str = "1";
            }
        }
        String trim2 = this.cAz.getText().toString().trim();
        if (this.cqP.anG()) {
            str = "1";
        } else if (!TextUtils.isEmpty(trim2)) {
            str = "1";
        } else if (this.cqP.anI()) {
            str = "1";
        } else if (this.cqP.anH()) {
            str = "1";
        }
        if (str == null || str.length() <= 0) {
            this.cAA.setEnabled(false);
        } else {
            this.cAA.setEnabled(true);
        }
    }

    private void initData(Bundle bundle) {
        this.aJU = new com.baidu.tieba.tbadkCore.writeModel.a(this);
        this.aJU.a(this.bKK);
        registerListener(this.cCK);
        this.bSJ = new bk(this);
        this.cup = new WriteData();
        if (bundle != null) {
            this.cup.setType(bundle.getInt("type", 0));
            this.cup.setForumId(bundle.getString("forum_id"));
            this.cup.setForumName(bundle.getString("forum_name"));
            this.cup.setThreadId(bundle.getString("thread_id"));
            this.cup.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.cup.setFloorNum(bundle.getInt(WriteActivityConfig.FLOOR_NUM, 0));
            this.cCl = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.cCu = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.cCv = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.writeImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.WRITE_IMAGES);
            this.baobaoImagesInfo = (WriteImagesInfo) bundle.getSerializable(WriteActivityConfig.BAOBAO_IMAGES);
            this.aJS = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            this.cCA = (AdditionData) bundle.getSerializable(WriteActivityConfig.ADDITION_DATA);
            this.cup.setIsAddition(this.cCA != null);
            this.mPrefixData = (PostPrefixData) bundle.getSerializable("prefix_data");
            this.cCF = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
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
                this.cup.setLiveCardData(liveCardData);
            }
        } else {
            Intent intent = getIntent();
            this.cup.setType(intent.getIntExtra("type", 0));
            this.cup.setForumId(intent.getStringExtra("forum_id"));
            this.cup.setForumName(intent.getStringExtra("forum_name"));
            this.cup.setThreadId(intent.getStringExtra("thread_id"));
            this.cup.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.cup.setFloorNum(intent.getIntExtra(WriteActivityConfig.FLOOR_NUM, 0));
            this.cCl = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.cCu = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.cCv = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.cCA = (AdditionData) intent.getSerializableExtra(WriteActivityConfig.ADDITION_DATA);
            this.cup.setIsAddition(this.cCA != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.cCF = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
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
                this.cup.setLiveCardData(liveCardData2);
            }
        }
        this.baobaoImagesInfo.setMaxImagesAllowed(1);
        this.writeImagesInfo.setMaxImagesAllowed(10);
        this.cup.setWriteImagesInfo(this.writeImagesInfo);
        this.cup.setBaobaoImagesInfo(this.baobaoImagesInfo);
        if (this.cup.getType() == 0) {
            if (this.cup.getLiveCardData() == null) {
                com.baidu.tieba.tbadkCore.ao.c(this.cup.getForumId(), this);
            } else {
                com.baidu.tieba.tbadkCore.ao.a(this.cup.getLiveCardData().getGroupId(), this);
            }
        } else if (this.cup.getType() == 1) {
            com.baidu.tieba.tbadkCore.ao.a(this.cup.getThreadId(), this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(0, getPageContext().getString(com.baidu.tieba.t.write_no_prefix));
        }
        this.bCQ = TbadkCoreApplication.m411getInst().getDefaultBubble();
        if (this.cup != null && this.cup.getForumName() != null && TbadkCoreApplication.m411getInst().getYijianfankuiFname() != null && this.cup.getForumName().equals(TbadkCoreApplication.m411getInst().getYijianfankuiFname())) {
            this.cCm = true;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ap
    public void a(WriteData writeData) {
        if (writeData != null && this.cup != null) {
            this.cup.setHaveDraft(true);
            if (com.baidu.adp.lib.util.m.isEmpty(this.cAv.getText().toString()) || ((this.cCl || this.cCm) && !com.baidu.adp.lib.util.m.isEmpty(writeData.getTitle()))) {
                this.cup.setTitle(writeData.getTitle());
                this.cAv.setText(this.cup.getTitle());
                this.cAv.setSelection(this.cup.getTitle().length());
            }
            if (writeData.getLiveCardData() != null) {
                Date date = new Date(writeData.getLiveCardData().getStartTime() * 1000);
                Date date2 = new Date();
                date.setYear(date2.getYear());
                date.setMonth(date2.getMonth());
                date.setDate(date2.getDate());
                this.cup.getLiveCardData().setStartTime(date.getTime() / 1000);
                this.cCH.setText(com.baidu.tbadk.core.util.bb.p(this.cup.getLiveCardData().getStartTime() * 1000));
            }
            if ((com.baidu.adp.lib.util.m.isEmpty(this.cAz.getText().toString()) || this.cCl || this.cCm) && !com.baidu.adp.lib.util.m.isEmpty(writeData.getContent())) {
                this.cup.setContent(writeData.getContent());
                SpannableString a = TbFaceManager.Al().a(getPageContext().getPageActivity(), this.cup.getContent(), new bl(this));
                this.cAz.setText(a);
                this.cAz.setSelection(a.length());
            }
            if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                this.writeImagesInfo = writeData.getWriteImagesInfo();
                this.cup.setWriteImagesInfo(this.writeImagesInfo);
                this.cqP.a(this.writeImagesInfo, true);
                fG(false);
            }
            if (TbadkCoreApplication.m411getInst().isBaobaoShouldOpen()) {
                if (writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                    this.baobaoImagesInfo.copyFrom(writeData.getBaobaoImagesInfo());
                    this.cup.setIsBaobao(writeData.getIsBaobao());
                    this.cup.setBaobaoContent(writeData.getBaobaoContent());
                    this.cup.setBaobaoImagesInfo(this.baobaoImagesInfo);
                }
                if (this.cup.getIsBaobao()) {
                    this.cqP.setBaobaoUris(this.baobaoImagesInfo);
                    fH(false);
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.cup.getType());
        bundle.putString("forum_id", this.cup.getForumId());
        bundle.putString("forum_name", this.cup.getForumName());
        bundle.putString("thread_id", this.cup.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.cup.getFloor());
        bundle.putInt(WriteActivityConfig.FLOOR_NUM, this.cup.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.cCu);
        if (this.cCl) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        bundle.putSerializable(WriteActivityConfig.WRITE_IMAGES, this.writeImagesInfo);
        bundle.putSerializable(WriteActivityConfig.BAOBAO_IMAGES, this.baobaoImagesInfo);
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aJS);
        bundle.putSerializable(WriteActivityConfig.ADDITION_DATA, this.cCA);
        bundle.putSerializable("prefix_data", this.mPrefixData);
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.cCF);
        if (this.cup.getLiveCardData() != null) {
            bundle.putBoolean(WriteActivityConfig.IS_LIVE_POST, true);
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ID, this.cup.getLiveCardData().getGroupId());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_HEAD, this.cup.getLiveCardData().getPortrait());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_INTRO, this.cup.getLiveCardData().getIntro());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_NAME, this.cup.getLiveCardData().getName());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_MEMBER_COUNT, this.cup.getLiveCardData().getListeners());
            bundle.putInt(WriteActivityConfig.LIVE_GROUP_ZAN_COUNT, this.cup.getLiveCardData().getLikers());
            bundle.putLong(WriteActivityConfig.LIVE_DATE, this.cup.getLiveCardData().getStartTime());
            bundle.putBoolean(WriteActivityConfig.LIVE_TIME_IS_MODIFY, this.cup.getLiveCardData().isModifyTime());
            bundle.putString(WriteActivityConfig.LIVE_GROUP_PUBLISH_HEAD, this.cup.getLiveCardData().getPublisherPortrait());
        }
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String editable = this.cAz.getEditableText().toString();
        if (editable != null) {
            this.cAz.setText(TbFaceManager.Al().F(getPageContext().getPageActivity(), editable));
            this.cAz.setSelection(this.cAz.getText().length());
        }
    }

    public void asB() {
        asy();
        if (this.cup.getLiveCardData() != null) {
            if (!this.cup.getLiveCardData().isModifyTime()) {
                this.cup.getLiveCardData().setStartTime(new Date().getTime() / 1000);
                this.cCH.setText(com.baidu.tbadk.core.util.bb.p(this.cup.getLiveCardData().getStartTime() * 1000));
            }
            long time = new Date().getTime() / TbConfig.USE_TIME_INTERVAL;
            Date date = new Date(this.cup.getLiveCardData().getStartTime() * 1000);
            Date date2 = new Date();
            date.setYear(date2.getYear());
            date.setMonth(date2.getMonth());
            date.setDate(date2.getDate());
            this.cup.getLiveCardData().setStartTime(date.getTime() / 1000);
            if (time > this.cup.getLiveCardData().getStartTime() / 60) {
                showToast(com.baidu.tieba.t.live_start_time_error);
                return;
            }
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0 && this.cAe != 0) {
            this.cup.setTitle(String.valueOf(this.cAB.getText().toString()) + this.cAv.getText().toString());
        } else {
            this.cup.setTitle(this.cAv.getText().toString());
        }
        this.cup.setContent(this.cAz.getText().toString());
        if (this.cCl || this.cCm) {
            String string = getResources().getString(com.baidu.tieba.t.android_feedback);
            if (TextUtils.isEmpty(this.cup.getTitle()) || !this.cup.getTitle().startsWith(string)) {
                this.cup.setTitle(string + this.cup.getTitle());
            }
            String str = String.valueOf(getResources().getString(com.baidu.tieba.t.app_name)) + getResources().getString(com.baidu.tieba.t.tieba_client);
            if (TextUtils.isEmpty(this.cup.getContent()) || !this.cup.getContent().startsWith(str)) {
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
                sb.append(this.cup.getContent());
                this.cup.setContent(sb.toString());
            }
        }
        this.cup.setWriteImagesInfo(this.writeImagesInfo);
        this.cup.setBaobaoImagesInfo(this.baobaoImagesInfo);
        this.cup.setHasLocationData(this.cCx.getLocationInfoViewState() == 2);
        this.aJU.fj(this.writeImagesInfo.size() > 0);
        this.aJU.c(this.cup);
        VoiceData.VoiceModel audioData = this.cqP.getAudioData();
        this.cqP.Ks();
        this.cup.setVcode(null);
        if (audioData != null) {
            if (audioData.getId() != null) {
                this.aJU.JT().setVoice(audioData.getId());
                this.aJU.JT().setVoiceDuringTime(audioData.duration);
            } else {
                this.aJU.JT().setVoice(null);
                this.aJU.JT().setVoiceDuringTime(-1);
            }
        } else {
            this.aJU.JT().setVoice(null);
            this.aJU.JT().setVoiceDuringTime(-1);
        }
        if (!this.aJU.apK()) {
            showToast(com.baidu.tieba.t.write_img_limit);
        } else if (this.aJU.apI()) {
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.t.sending), this.bSJ);
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
            if (this.cCA != null) {
                i2 = this.cCA.getTotalCount();
                i = this.cCA.getAlreadyCount() + 1;
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
                            this.cAz.getText().insert(this.cAz.getSelectionStart(), sb2);
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                if (this.cup.getType() == 0) {
                    com.baidu.tieba.tbadkCore.ao.a(this.cup.getForumId(), (WriteData) null);
                } else if (this.cup.getType() == 1) {
                    com.baidu.tieba.tbadkCore.ao.b(this.cup.getThreadId(), (WriteData) null);
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
                asG();
            } else if (i == 12013) {
                S(intent);
                asG();
            } else if (i == 23004) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12001:
                    JU();
                    return;
                case 12002:
                    if (!this.cqP.anG()) {
                        atp();
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
                    this.aJS = String.valueOf(System.currentTimeMillis());
                    com.baidu.tbadk.core.util.ax.a(getPageContext(), this.aJS);
                    return;
                default:
                    return;
            }
        }
    }

    private void Y(Intent intent) {
        P(intent);
        asG();
        this.cqP.setVisibility(0);
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
        HidenSoftKeyPad(this.mInputManager, this.cAv);
        HidenSoftKeyPad(this.mInputManager, this.cAz);
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void P(Intent intent) {
        b(intent, true);
    }

    public boolean atw() {
        boolean anI = this.cqP.anI();
        LinkedList<ImageFileInfo> chosedFiles = this.baobaoImagesInfo.getChosedFiles();
        return !anI && (chosedFiles == null || chosedFiles.isEmpty());
    }

    private void K(Intent intent) {
        this.aJS = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aJS;
        if (!TextUtils.isEmpty(str)) {
            try {
                int cu = com.baidu.tbadk.core.util.c.cu(str);
                if (cu != 0) {
                    Bitmap b = com.baidu.tbadk.core.util.c.b(str, com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.M(getPageContext().getPageActivity())), com.baidu.adp.lib.util.n.dip2px(getPageContext().getPageActivity(), com.baidu.adp.lib.util.n.N(getPageContext().getPageActivity())));
                    Bitmap h = com.baidu.tbadk.core.util.c.h(b, cu);
                    if (b != h) {
                        b.recycle();
                    }
                    com.baidu.tbadk.core.util.o.a(TbConfig.LOCAL_CAMERA_DIR, this.aJS, h, 100);
                    h.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            this.cqP.a(this.writeImagesInfo, true);
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
                    this.cqP.a(this.writeImagesInfo, z);
                }
            }
            fG(true);
        }
    }

    private void S(Intent intent) {
        if (this.cup != null) {
            String stringExtra = intent.getStringExtra("key_bitmap_path");
            String stringExtra2 = intent.getStringExtra("key_content");
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(stringExtra);
            this.baobaoImagesInfo.clear();
            this.baobaoImagesInfo.addChooseFile(imageFileInfo);
            this.cup.setIsBaobao(true);
            this.cup.setBaobaoContent(stringExtra2);
            this.cqP.setBaobaoUris(this.baobaoImagesInfo);
            fH(true);
        }
    }

    private void JU() {
        new bm(this).execute(new Void[0]);
    }

    private void fG(boolean z) {
        LinkedList<ImageFileInfo> chosedFiles = this.writeImagesInfo.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.cCy.eC(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            this.cCz = true;
            this.cqP.eC(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            if (this.cqP.anx() || z) {
                this.cqP.anD();
                return;
            }
            return;
        }
        this.cCy.zJ();
        this.cCz = false;
        this.cqP.zJ();
        if (this.cqP.anI()) {
            this.cqP.zR();
            this.cCy.aoe();
        }
        atp();
    }

    private void fH(boolean z) {
        LinkedList<ImageFileInfo> chosedFiles = this.baobaoImagesInfo.getChosedFiles();
        if (chosedFiles != null && chosedFiles.size() > 0) {
            this.cCy.asj();
            this.cCy.aoe();
            if (this.cqP.anx() || z) {
                this.cqP.anF();
            }
            this.cup.setIsBaobao(true);
            return;
        }
        if (atw()) {
            this.cCy.aof();
        }
        this.cup.setIsBaobao(false);
        this.cCy.asi();
        atp();
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
            antiData.setBlock_forum_name(this.cup.getForumName());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.WRITE);
        } else if (this.cCA == null) {
            com.baidu.tieba.tbadkCore.writeModel.h.d(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        } else {
            l(z, str);
        }
    }

    public void a(boolean z, AntiData antiData, String str) {
        if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
            antiData.setBlock_forum_name(this.cup.getForumName());
            AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.WRITE);
        } else if (this.cCA == null) {
            com.baidu.tieba.tbadkCore.writeModel.h.O(getPageContext().getPageActivity(), str);
        } else {
            l(z, str);
        }
    }

    private void jG(int i) {
        if (i < this.cCq.size()) {
            for (int i2 = 0; i2 < this.cCq.size(); i2++) {
                this.cCq.get(i2).fD(false);
            }
            this.cCq.get(i).fD(true);
        }
    }

    @Override // com.baidu.tieba.write.write.co
    public void jv(int i) {
        this.cAe = i;
        this.cAC.setCurrentIndex(i);
        jG(i);
        this.cAB.setText(this.mPrefixData.getPrefixs().get(i));
        asG();
        com.baidu.adp.lib.g.k.a(this.cAC, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.cAE.setSelected(false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
