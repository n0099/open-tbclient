package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.editortool.EmotionTabHost;
import com.baidu.tbadk.editortool.ToolMoreView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.av;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class EditorToolComponetContainer extends RelativeLayout implements com.baidu.tieba.tbadkCore.imgView.d {
    protected LinearLayout XI;
    private com.baidu.tbadk.editortool.v aix;
    private boolean akd;
    protected final af cmA;
    private WriteImagesInfo cmB;
    private WriteImagesInfo cmC;
    private com.baidu.tbadk.img.e cmD;
    protected ToolMoreView cmh;
    protected EmotionTabHost cmi;
    protected com.baidu.tieba.tbadkCore.voice.b cmj;
    protected com.baidu.tieba.tbadkCore.voice.c cmk;
    protected View cml;
    protected View cmm;
    protected DragContainer cmn;
    protected DragLayer cmo;
    protected DragHorizonScrollView cmp;
    protected DragContainer cmq;
    protected DragLayer cmr;
    protected DragHorizonScrollView cms;
    protected TextView cmt;
    protected TextView cmu;
    protected o cmv;
    protected boolean cmw;
    private final boolean cmx;
    private boolean cmy;
    private int cmz;
    protected Context mContext;
    private int padding;

    public EditorToolComponetContainer(Context context) {
        super(context);
        this.cmw = false;
        this.cmx = true;
        this.akd = false;
        this.cmA = new af();
        this.mContext = context;
        initialize();
    }

    public EditorToolComponetContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cmw = false;
        this.cmx = true;
        this.akd = false;
        this.cmA = new af();
        this.mContext = context;
        initialize();
    }

    protected void initialize() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.editor_tool_container, this, true);
        this.XI = (LinearLayout) findViewById(com.baidu.tieba.v.tools_container);
        this.cmh = (ToolMoreView) findViewById(com.baidu.tieba.v.tool_view);
        this.cmm = findViewById(com.baidu.tieba.v.pb_foot_down_shadow);
        if (a.all() && this.cmh.getBaobao() != null && this.cmh.getBaobao().isShown()) {
            this.cmh.en("N");
        }
    }

    private void alu() {
        if (this.cmj == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001279, com.baidu.tieba.tbadkCore.voice.b.class, this.mContext);
            if (runTask != null && runTask.getData() != null) {
                this.cmj = (com.baidu.tieba.tbadkCore.voice.b) runTask.getData();
            }
            if (this.cmj != null) {
                this.XI.addView(this.cmj, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.pb_editor_faceview_height)));
                this.cmj.setVisibility(8);
                ba.i(this.cmj, com.baidu.tieba.s.record_voice_container_bg);
                if (this.cmk != null) {
                    this.cmj.setCallback(this.cmk);
                }
                if (this.aix != null) {
                    this.aix.handleAction(54, null);
                }
            }
        }
    }

    private void alv() {
        if (this.cmi == null) {
            this.cmi = new EmotionTabHost(this.mContext);
            this.XI.addView(this.cmi, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.pb_editor_faceview_height)));
            this.cmi.setVisibility(8);
            this.cmi.setShowBigEmotion(!this.cmy);
            this.cmi.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
            this.cmi.setOnDataSelected(new d(this));
        }
    }

    private void alw() {
        if (this.cmn == null) {
            com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.editor_tool_container_image, this.XI);
            this.cmn = (DragContainer) findViewById(com.baidu.tieba.v.muti_image_upload);
            this.cmo = (DragLayer) findViewById(com.baidu.tieba.v.muti_image_upload_draglayer);
            this.cmp = (DragHorizonScrollView) findViewById(com.baidu.tieba.v.muti_image_upload_dragscrollview);
            com.baidu.tieba.tbadkCore.imgView.a aVar = new com.baidu.tieba.tbadkCore.imgView.a(getContext());
            aVar.a(this.cmo);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.g) this.cmp);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.f) this.cmp);
            this.cmu = (TextView) findViewById(com.baidu.tieba.v.muti_image_tips);
            this.cmz = getResources().getDimensionPixelSize(com.baidu.tieba.t.editor_muti_image_upload_scrollview_paddingleft);
            this.padding = getResources().getDimensionPixelSize(com.baidu.tieba.t.default_gap_24);
            this.cmp.setAddView(ip(7));
            this.cmp.setOnSwapDataListener(this);
            this.cmp.setMaxItemNum(10);
            if (this.cmD == null) {
                this.cmD = new com.baidu.tbadk.img.e(this.mContext);
            }
            ba.b(this.cmu, com.baidu.tieba.s.cp_cont_c, 1);
        }
    }

    private void alx() {
        if (this.cmq == null) {
            com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.editor_tool_container_baobao, this.XI);
            this.cmq = (DragContainer) findViewById(com.baidu.tieba.v.baobao_image_upload);
            this.cmr = (DragLayer) findViewById(com.baidu.tieba.v.baobao_image_upload_draglayer);
            this.cms = (DragHorizonScrollView) findViewById(com.baidu.tieba.v.baobao_image_upload_dragscrollview);
            this.cmt = (TextView) findViewById(com.baidu.tieba.v.baobao_image_tips);
            com.baidu.tieba.tbadkCore.imgView.a aVar = new com.baidu.tieba.tbadkCore.imgView.a(getContext());
            aVar.a(this.cmr);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.g) this.cms);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.f) this.cms);
            this.cms.setAddView(ip(48));
            this.cms.setOnSwapDataListener(this);
            this.cms.setMaxItemNum(1);
            this.cms.setCenterStart(true);
            if (this.cmD == null) {
                this.cmD = new com.baidu.tbadk.img.e(this.mContext);
            }
        }
    }

    private void aly() {
        if (this.cmv == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001289, o.class, this.mContext);
            if (runTask != null && runTask.getData() != null) {
                this.cmv = (o) runTask.getData();
            }
            if (this.cmv != null) {
                this.XI.addView(this.cmv, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.pb_editor_faceview_height)));
                this.cmv.setVisibility(8);
                this.cmv.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
                this.cmv.setOnDataSelected(new e(this));
            }
        }
    }

    protected void alz() {
        com.baidu.adp.base.l B = com.baidu.adp.base.m.B(this.mContext);
        if (B != null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2010041, this.cmA);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2010041, B.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessageToUI(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alA() {
        if (alV()) {
            this.cmA.cnq = 1;
        } else {
            this.cmA.cnq = 0;
        }
        if (this.cmB != null && this.cmB.getChosedFiles() != null && this.cmB.getChosedFiles().size() > 0) {
            this.cmA.cnp = this.cmB.getChosedFiles().size();
        } else {
            this.cmA.cnp = 0;
        }
        if (this.cmC != null && this.cmC.getChosedFiles() != null && this.cmC.getChosedFiles().size() > 0) {
            this.cmA.cnr = this.cmC.getChosedFiles().size();
        } else {
            this.cmA.cnr = 0;
        }
        alz();
    }

    public void setHideBaobao(boolean z) {
        this.akd = z;
        if (this.cmh != null) {
            this.cmh.setHideBaobao(z);
            if (z && a.all()) {
                this.cmh.zc();
            }
        }
    }

    public void setShadowBackground(int i) {
        if (this.cmm != null) {
            ba.j(this.cmm, i);
        }
    }

    public void setShadowHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (i > 0 && (layoutParams = this.cmm.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.cmm.setLayoutParams(layoutParams);
        }
    }

    public void setFrom(int i) {
        if (this.cmi != null) {
            this.cmi.setFrom(i);
        }
    }

    protected void alB() {
        alv();
        this.cmm.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().getKeyboardHeight() > 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmi.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.cmi.setLayoutParams(layoutParams);
        }
        this.cmi.setVisibility(0);
    }

    protected void alC() {
        if (this.cmi != null) {
            this.cmi.setVisibility(8);
        }
    }

    protected void abn() {
        alu();
        if (this.cmj != null) {
            this.cmm.setVisibility(0);
            if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmj.getLayoutParams();
                layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
                this.cmj.setLayoutParams(layoutParams);
            }
            this.cmj.setVisibility(0);
        }
    }

    protected void abm() {
        if (this.cmj != null) {
            this.cmj.setVisibility(8);
        }
    }

    protected void alD() {
        this.cmm.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmh.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.cmh.setLayoutParams(layoutParams);
        }
        this.cmh.setVisibility(0);
    }

    public void alE() {
        if (this.cmn != null) {
            this.cmn.setVisibility(8);
        }
    }

    public void alF() {
        alw();
        this.cmm.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmn.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.cmn.setLayoutParams(layoutParams);
        }
        this.cmn.setVisibility(0);
    }

    public void alG() {
        if (this.cmq != null) {
            this.cmq.setVisibility(8);
        }
    }

    public void zc() {
        this.cmh.zc();
    }

    public void el(String str) {
        if (this.cmh != null) {
            this.cmh.el(str);
        }
    }

    public void yV() {
        if (this.cmh != null) {
            this.cmh.yV();
        }
    }

    public void zd() {
        if (this.cmh != null) {
            this.cmh.zd();
        }
    }

    public void ze() {
        if (this.cmh != null) {
            this.cmh.ze();
        }
    }

    public boolean yZ() {
        if (this.cmh == null) {
            return false;
        }
        return this.cmh.yZ();
    }

    public void za() {
        if (this.cmh != null) {
            this.cmh.za();
        }
    }

    public void zb() {
        if (this.cmh != null) {
            this.cmh.zb();
        }
    }

    public void alH() {
        alx();
        this.cmm.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmq.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.cmq.setLayoutParams(layoutParams);
        }
        this.cmq.setVisibility(0);
        if (TextUtils.isEmpty(this.cmt.getText())) {
            this.cmt.setText(com.baidu.tieba.y.baobao_remind);
        }
    }

    protected void hideMore() {
        this.cmh.setVisibility(8);
    }

    protected void alI() {
        aly();
        this.cmm.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmv.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.cmv.setLayoutParams(layoutParams);
        }
        this.cmv.setVisibility(0);
    }

    protected void alJ() {
        if (this.cmv != null) {
            this.cmv.setVisibility(8);
        }
    }

    public void Y(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.n.d(this.mContext, view);
            this.cmw = true;
        }
    }

    public void Z(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.n.c(this.mContext, view);
            this.cmw = false;
        }
    }

    public boolean alK() {
        return this.cmh.getVisibility() == 0 || (this.cmj != null && this.cmj.getVisibility() == 0) || ((this.cmi != null && this.cmi.getVisibility() == 0) || ((this.cmn != null && this.cmn.getVisibility() == 0) || ((this.cmv != null && this.cmv.getVisibility() == 0) || (this.cmq != null && this.cmq.getVisibility() == 0))));
    }

    public void hideAll() {
        alL();
        Z(this.cml);
    }

    public void alL() {
        this.cmm.setVisibility(8);
        hideMore();
        abm();
        alC();
        alE();
        alJ();
        alG();
    }

    public void alM() {
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            if (this.cmh != null && this.cmh.getVisibility() == 0) {
                alD();
            } else if (this.cmi != null && this.cmi.getVisibility() == 0) {
                alB();
            } else if (this.cmj != null && this.cmj.getVisibility() == 0) {
                abn();
            } else if (this.cmn != null && this.cmn.getVisibility() == 0) {
                alF();
            } else if (this.cmv != null && this.cmv.getVisibility() == 0) {
                alI();
            } else if (this.cmq != null && this.cmq.getVisibility() == 0) {
                alH();
            }
        }
    }

    public void alN() {
        hideAll();
        alD();
    }

    public void alO() {
        hideAll();
        alB();
    }

    public void alP() {
        hideAll();
        abn();
    }

    public void alQ() {
        hideAll();
        alF();
    }

    public void alR() {
        hideAll();
        alI();
    }

    public void alS() {
        hideAll();
        alH();
    }

    public void aa(View view) {
        if (!this.cmw) {
            hideAll();
            this.cml = view;
            Y(view);
        }
    }

    public boolean alT() {
        BaseAdapter adapter;
        return (this.cmp == null || (adapter = this.cmp.getAdapter()) == null || adapter.getCount() <= 0) ? false : true;
    }

    public boolean alU() {
        BaseAdapter adapter;
        return (this.cms == null || (adapter = this.cms.getAdapter()) == null || adapter.getCount() <= 0) ? false : true;
    }

    public boolean alV() {
        VoiceData.VoiceModel voiceModel;
        return (this.cmj == null || (voiceModel = this.cmj.getVoiceModel()) == null || voiceModel.getId() == null || voiceModel.getId().length() <= 0) ? false : true;
    }

    public VoiceData.VoiceModel getAudioData() {
        if (this.cmj == null) {
            return null;
        }
        return this.cmj.getVoiceModel();
    }

    public void alW() {
        if (this.cmk != null) {
            this.cmk.ama();
        }
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        if (this.cmj != null && voiceModel != null) {
            this.cmj.a(voiceModel);
        }
    }

    public void Jm() {
        if (this.cmj != null) {
            this.cmj.of();
        }
    }

    public void clearData() {
        if (this.cmj != null) {
            this.cmj.reset();
            setImage(null);
            this.cmh.zc();
        }
    }

    public void Jn() {
        if (this.cmj != null) {
            this.cmj.onStopingRecorder();
        }
    }

    public void alX() {
        Jn();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        this.aix = new f(this, vVar);
        this.cmh.setOnClickListener(new g(this));
        this.cmk = new h(this);
        if (this.cmj != null) {
            this.cmj.setCallback(this.cmk);
        }
    }

    public boolean alY() {
        return this.cmw;
    }

    public void setImage(Bitmap bitmap) {
        if (bitmap == null) {
            this.cmh.setmImagetype(0);
        }
        this.cmh.setImage(bitmap);
    }

    public void aQ(boolean z) {
        this.cmy = z;
        this.cmh.aQ(z);
        if (this.cmi != null) {
            this.cmi.setShowBigEmotion(!z);
        }
    }

    public void zh() {
        this.cmh.zh();
    }

    public void zg() {
        this.cmh.zg();
    }

    public void zi() {
        this.cmh.zi();
    }

    public void onChangeSkinType(int i) {
        if (this.cmi != null) {
            this.cmi.onChangeSkinType(i);
        }
        this.cmh.onChangeSkinType(i);
        if (this.cmv != null) {
            this.cmv.onChangeSkinType(i);
        }
        if (this.cmj != null) {
            ba.i(this.cmj, com.baidu.tieba.s.record_voice_container_bg);
        }
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        alw();
        this.cmB = writeImagesInfo;
        this.cmp.a(new j(this, writeImagesInfo), z);
        int maxItemNum = this.cmp.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (!av.amt().amu() && size > 1) {
            this.cmu.setText(com.baidu.tieba.y.editor_mutiiamge_drag_tip);
            av.amt().eM(true);
        } else {
            this.cmu.setText(getResources().getString(com.baidu.tieba.y.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
        }
        if (size > 0) {
            this.cmh.el(new StringBuilder(String.valueOf(size)).toString());
        } else {
            this.cmh.yV();
        }
        this.aix.handleAction(13, null);
        alA();
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        alx();
        this.cmC = writeImagesInfo;
        this.cms.a((BaseAdapter) new j(this, this.cmC), false);
        this.aix.handleAction(51, null);
        if (this.cmC.size() > 0) {
            this.cmh.en("1");
        } else {
            this.cmh.zc();
        }
        this.aix.handleAction(51, null);
        alA();
    }

    private View ip(int i) {
        TbadkCoreApplication.m411getInst().getSkinType();
        ImageView imageView = new ImageView(getContext());
        ba.c(imageView, com.baidu.tieba.u.btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        int dip2px = com.baidu.adp.lib.util.n.dip2px(this.mContext, 3.0f);
        imageView.setPadding(dip2px, com.baidu.adp.lib.util.n.dip2px(this.mContext, 1.0f) + getResources().getDimensionPixelSize(com.baidu.tieba.t.default_gap_20) + dip2px, this.padding + dip2px, dip2px);
        imageView.setOnClickListener(new i(this, i));
        return imageView;
    }

    public void alZ() {
        if (this.cmp != null) {
            this.cmp.notifyDataSetChanged();
        }
        if (this.cms != null) {
            this.cms.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void af(int i, int i2) {
        if (i != i2 && this.cmB != null && this.cmB.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.cmB.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void refresh() {
        if (this.cmy) {
            this.cmh.yY();
        } else if (TextUtils.isEmpty(TbadkCoreApplication.m411getInst().getDefaultBubble()) && !this.cmy) {
            this.cmh.yY();
        } else {
            this.cmh.yX();
        }
    }
}
