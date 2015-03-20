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
    protected LinearLayout XG;
    private com.baidu.tbadk.editortool.v aip;
    private boolean ajV;
    protected ToolMoreView clQ;
    protected EmotionTabHost clR;
    protected com.baidu.tieba.tbadkCore.voice.b clS;
    protected com.baidu.tieba.tbadkCore.voice.c clT;
    protected View clU;
    protected View clV;
    protected DragContainer clW;
    protected DragLayer clX;
    protected DragHorizonScrollView clY;
    protected DragContainer clZ;
    protected DragLayer cma;
    protected DragHorizonScrollView cmb;
    protected TextView cmc;
    protected TextView cme;
    protected o cmf;
    protected boolean cmg;
    private final boolean cmh;
    private boolean cmi;
    private int cmj;
    protected final af cmk;
    private WriteImagesInfo cml;
    private WriteImagesInfo cmm;
    private com.baidu.tbadk.img.e cmn;
    protected Context mContext;
    private int padding;

    public EditorToolComponetContainer(Context context) {
        super(context);
        this.cmg = false;
        this.cmh = true;
        this.ajV = false;
        this.cmk = new af();
        this.mContext = context;
        initialize();
    }

    public EditorToolComponetContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cmg = false;
        this.cmh = true;
        this.ajV = false;
        this.cmk = new af();
        this.mContext = context;
        initialize();
    }

    protected void initialize() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.editor_tool_container, this, true);
        this.XG = (LinearLayout) findViewById(com.baidu.tieba.v.tools_container);
        this.clQ = (ToolMoreView) findViewById(com.baidu.tieba.v.tool_view);
        this.clV = findViewById(com.baidu.tieba.v.pb_foot_down_shadow);
        if (a.akW() && this.clQ.getBaobao() != null && this.clQ.getBaobao().isShown()) {
            this.clQ.ek("N");
        }
    }

    private void alf() {
        if (this.clS == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001279, com.baidu.tieba.tbadkCore.voice.b.class, this.mContext);
            if (runTask != null && runTask.getData() != null) {
                this.clS = (com.baidu.tieba.tbadkCore.voice.b) runTask.getData();
            }
            if (this.clS != null) {
                this.XG.addView(this.clS, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.pb_editor_faceview_height)));
                this.clS.setVisibility(8);
                ba.i(this.clS, com.baidu.tieba.s.record_voice_container_bg);
                if (this.clT != null) {
                    this.clS.setCallback(this.clT);
                }
                if (this.aip != null) {
                    this.aip.handleAction(54, null);
                }
            }
        }
    }

    private void alg() {
        if (this.clR == null) {
            this.clR = new EmotionTabHost(this.mContext);
            this.XG.addView(this.clR, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.pb_editor_faceview_height)));
            this.clR.setVisibility(8);
            this.clR.setShowBigEmotion(!this.cmi);
            this.clR.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
            this.clR.setOnDataSelected(new d(this));
        }
    }

    private void alh() {
        if (this.clW == null) {
            com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.editor_tool_container_image, this.XG);
            this.clW = (DragContainer) findViewById(com.baidu.tieba.v.muti_image_upload);
            this.clX = (DragLayer) findViewById(com.baidu.tieba.v.muti_image_upload_draglayer);
            this.clY = (DragHorizonScrollView) findViewById(com.baidu.tieba.v.muti_image_upload_dragscrollview);
            com.baidu.tieba.tbadkCore.imgView.a aVar = new com.baidu.tieba.tbadkCore.imgView.a(getContext());
            aVar.a(this.clX);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.g) this.clY);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.f) this.clY);
            this.cme = (TextView) findViewById(com.baidu.tieba.v.muti_image_tips);
            this.cmj = getResources().getDimensionPixelSize(com.baidu.tieba.t.editor_muti_image_upload_scrollview_paddingleft);
            this.padding = getResources().getDimensionPixelSize(com.baidu.tieba.t.default_gap_24);
            this.clY.setAddView(im(7));
            this.clY.setOnSwapDataListener(this);
            this.clY.setMaxItemNum(10);
            if (this.cmn == null) {
                this.cmn = new com.baidu.tbadk.img.e(this.mContext);
            }
            ba.b(this.cme, com.baidu.tieba.s.cp_cont_c, 1);
        }
    }

    private void ali() {
        if (this.clZ == null) {
            com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.editor_tool_container_baobao, this.XG);
            this.clZ = (DragContainer) findViewById(com.baidu.tieba.v.baobao_image_upload);
            this.cma = (DragLayer) findViewById(com.baidu.tieba.v.baobao_image_upload_draglayer);
            this.cmb = (DragHorizonScrollView) findViewById(com.baidu.tieba.v.baobao_image_upload_dragscrollview);
            this.cmc = (TextView) findViewById(com.baidu.tieba.v.baobao_image_tips);
            com.baidu.tieba.tbadkCore.imgView.a aVar = new com.baidu.tieba.tbadkCore.imgView.a(getContext());
            aVar.a(this.cma);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.g) this.cmb);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.f) this.cmb);
            this.cmb.setAddView(im(48));
            this.cmb.setOnSwapDataListener(this);
            this.cmb.setMaxItemNum(1);
            this.cmb.setCenterStart(true);
            if (this.cmn == null) {
                this.cmn = new com.baidu.tbadk.img.e(this.mContext);
            }
        }
    }

    private void alj() {
        if (this.cmf == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001289, o.class, this.mContext);
            if (runTask != null && runTask.getData() != null) {
                this.cmf = (o) runTask.getData();
            }
            if (this.cmf != null) {
                this.XG.addView(this.cmf, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.t.pb_editor_faceview_height)));
                this.cmf.setVisibility(8);
                this.cmf.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
                this.cmf.setOnDataSelected(new e(this));
            }
        }
    }

    protected void alk() {
        com.baidu.adp.base.l B = com.baidu.adp.base.m.B(this.mContext);
        if (B != null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2010041, this.cmk);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2010041, B.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessageToUI(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void all() {
        if (alG()) {
            this.cmk.cna = 1;
        } else {
            this.cmk.cna = 0;
        }
        if (this.cml != null && this.cml.getChosedFiles() != null && this.cml.getChosedFiles().size() > 0) {
            this.cmk.cmZ = this.cml.getChosedFiles().size();
        } else {
            this.cmk.cmZ = 0;
        }
        if (this.cmm != null && this.cmm.getChosedFiles() != null && this.cmm.getChosedFiles().size() > 0) {
            this.cmk.cnb = this.cmm.getChosedFiles().size();
        } else {
            this.cmk.cnb = 0;
        }
        alk();
    }

    public void setHideBaobao(boolean z) {
        this.ajV = z;
        if (this.clQ != null) {
            this.clQ.setHideBaobao(z);
            if (z && a.akW()) {
                this.clQ.yW();
            }
        }
    }

    public void setShadowBackground(int i) {
        if (this.clV != null) {
            ba.j(this.clV, i);
        }
    }

    public void setShadowHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (i > 0 && (layoutParams = this.clV.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.clV.setLayoutParams(layoutParams);
        }
    }

    public void setFrom(int i) {
        if (this.clR != null) {
            this.clR.setFrom(i);
        }
    }

    protected void alm() {
        alg();
        this.clV.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().getKeyboardHeight() > 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clR.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.clR.setLayoutParams(layoutParams);
        }
        this.clR.setVisibility(0);
    }

    protected void aln() {
        if (this.clR != null) {
            this.clR.setVisibility(8);
        }
    }

    protected void aaZ() {
        alf();
        if (this.clS != null) {
            this.clV.setVisibility(0);
            if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clS.getLayoutParams();
                layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
                this.clS.setLayoutParams(layoutParams);
            }
            this.clS.setVisibility(0);
        }
    }

    protected void aaY() {
        if (this.clS != null) {
            this.clS.setVisibility(8);
        }
    }

    protected void alo() {
        this.clV.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clQ.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.clQ.setLayoutParams(layoutParams);
        }
        this.clQ.setVisibility(0);
    }

    public void alp() {
        if (this.clW != null) {
            this.clW.setVisibility(8);
        }
    }

    public void alq() {
        alh();
        this.clV.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clW.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.clW.setLayoutParams(layoutParams);
        }
        this.clW.setVisibility(0);
    }

    public void alr() {
        if (this.clZ != null) {
            this.clZ.setVisibility(8);
        }
    }

    public void yW() {
        this.clQ.yW();
    }

    public void ei(String str) {
        if (this.clQ != null) {
            this.clQ.ei(str);
        }
    }

    public void yP() {
        if (this.clQ != null) {
            this.clQ.yP();
        }
    }

    public void yX() {
        if (this.clQ != null) {
            this.clQ.yX();
        }
    }

    public void yY() {
        if (this.clQ != null) {
            this.clQ.yY();
        }
    }

    public boolean yT() {
        if (this.clQ == null) {
            return false;
        }
        return this.clQ.yT();
    }

    public void yU() {
        if (this.clQ != null) {
            this.clQ.yU();
        }
    }

    public void yV() {
        if (this.clQ != null) {
            this.clQ.yV();
        }
    }

    public void als() {
        ali();
        this.clV.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.clZ.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.clZ.setLayoutParams(layoutParams);
        }
        this.clZ.setVisibility(0);
        if (TextUtils.isEmpty(this.cmc.getText())) {
            this.cmc.setText(com.baidu.tieba.y.baobao_remind);
        }
    }

    protected void hideMore() {
        this.clQ.setVisibility(8);
    }

    protected void alt() {
        alj();
        this.clV.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmf.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.cmf.setLayoutParams(layoutParams);
        }
        this.cmf.setVisibility(0);
    }

    protected void alu() {
        if (this.cmf != null) {
            this.cmf.setVisibility(8);
        }
    }

    public void Y(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.n.d(this.mContext, view);
            this.cmg = true;
        }
    }

    public void Z(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.n.c(this.mContext, view);
            this.cmg = false;
        }
    }

    public boolean alv() {
        return this.clQ.getVisibility() == 0 || (this.clS != null && this.clS.getVisibility() == 0) || ((this.clR != null && this.clR.getVisibility() == 0) || ((this.clW != null && this.clW.getVisibility() == 0) || ((this.cmf != null && this.cmf.getVisibility() == 0) || (this.clZ != null && this.clZ.getVisibility() == 0))));
    }

    public void hideAll() {
        alw();
        Z(this.clU);
    }

    public void alw() {
        this.clV.setVisibility(8);
        hideMore();
        aaY();
        aln();
        alp();
        alu();
        alr();
    }

    public void alx() {
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            if (this.clQ != null && this.clQ.getVisibility() == 0) {
                alo();
            } else if (this.clR != null && this.clR.getVisibility() == 0) {
                alm();
            } else if (this.clS != null && this.clS.getVisibility() == 0) {
                aaZ();
            } else if (this.clW != null && this.clW.getVisibility() == 0) {
                alq();
            } else if (this.cmf != null && this.cmf.getVisibility() == 0) {
                alt();
            } else if (this.clZ != null && this.clZ.getVisibility() == 0) {
                als();
            }
        }
    }

    public void aly() {
        hideAll();
        alo();
    }

    public void alz() {
        hideAll();
        alm();
    }

    public void alA() {
        hideAll();
        aaZ();
    }

    public void alB() {
        hideAll();
        alq();
    }

    public void alC() {
        hideAll();
        alt();
    }

    public void alD() {
        hideAll();
        als();
    }

    public void aa(View view) {
        if (!this.cmg) {
            hideAll();
            this.clU = view;
            Y(view);
        }
    }

    public boolean alE() {
        BaseAdapter adapter;
        return (this.clY == null || (adapter = this.clY.getAdapter()) == null || adapter.getCount() <= 0) ? false : true;
    }

    public boolean alF() {
        BaseAdapter adapter;
        return (this.cmb == null || (adapter = this.cmb.getAdapter()) == null || adapter.getCount() <= 0) ? false : true;
    }

    public boolean alG() {
        VoiceData.VoiceModel voiceModel;
        return (this.clS == null || (voiceModel = this.clS.getVoiceModel()) == null || voiceModel.getId() == null || voiceModel.getId().length() <= 0) ? false : true;
    }

    public VoiceData.VoiceModel getAudioData() {
        if (this.clS == null) {
            return null;
        }
        return this.clS.getVoiceModel();
    }

    public void alH() {
        if (this.clT != null) {
            this.clT.alL();
        }
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        if (this.clS != null && voiceModel != null) {
            this.clS.a(voiceModel);
        }
    }

    public void Jg() {
        if (this.clS != null) {
            this.clS.of();
        }
    }

    public void clearData() {
        if (this.clS != null) {
            this.clS.reset();
            setImage(null);
            this.clQ.yW();
        }
    }

    public void Jh() {
        if (this.clS != null) {
            this.clS.onStopingRecorder();
        }
    }

    public void alI() {
        Jh();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        this.aip = new f(this, vVar);
        this.clQ.setOnClickListener(new g(this));
        this.clT = new h(this);
        if (this.clS != null) {
            this.clS.setCallback(this.clT);
        }
    }

    public boolean alJ() {
        return this.cmg;
    }

    public void setImage(Bitmap bitmap) {
        if (bitmap == null) {
            this.clQ.setmImagetype(0);
        }
        this.clQ.setImage(bitmap);
    }

    public void aQ(boolean z) {
        this.cmi = z;
        this.clQ.aQ(z);
        if (this.clR != null) {
            this.clR.setShowBigEmotion(!z);
        }
    }

    public void zb() {
        this.clQ.zb();
    }

    public void za() {
        this.clQ.za();
    }

    public void zc() {
        this.clQ.zc();
    }

    public void onChangeSkinType(int i) {
        if (this.clR != null) {
            this.clR.onChangeSkinType(i);
        }
        this.clQ.onChangeSkinType(i);
        if (this.cmf != null) {
            this.cmf.onChangeSkinType(i);
        }
        if (this.clS != null) {
            ba.i(this.clS, com.baidu.tieba.s.record_voice_container_bg);
        }
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        alh();
        this.cml = writeImagesInfo;
        this.clY.a(new j(this, writeImagesInfo), z);
        int maxItemNum = this.clY.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (!av.ame().amf() && size > 1) {
            this.cme.setText(com.baidu.tieba.y.editor_mutiiamge_drag_tip);
            av.ame().eO(true);
        } else {
            this.cme.setText(getResources().getString(com.baidu.tieba.y.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
        }
        if (size > 0) {
            this.clQ.ei(new StringBuilder(String.valueOf(size)).toString());
        } else {
            this.clQ.yP();
        }
        this.aip.handleAction(13, null);
        all();
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        ali();
        this.cmm = writeImagesInfo;
        this.cmb.a((BaseAdapter) new j(this, this.cmm), false);
        this.aip.handleAction(51, null);
        if (this.cmm.size() > 0) {
            this.clQ.ek("1");
        } else {
            this.clQ.yW();
        }
        this.aip.handleAction(51, null);
        all();
    }

    private View im(int i) {
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

    public void alK() {
        if (this.clY != null) {
            this.clY.notifyDataSetChanged();
        }
        if (this.cmb != null) {
            this.cmb.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void af(int i, int i2) {
        if (i != i2 && this.cml != null && this.cml.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.cml.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void refresh() {
        if (this.cmi) {
            this.clQ.yS();
        } else if (TextUtils.isEmpty(TbadkCoreApplication.m411getInst().getDefaultBubble()) && !this.cmi) {
            this.clQ.yS();
        } else {
            this.clQ.yR();
        }
    }
}
