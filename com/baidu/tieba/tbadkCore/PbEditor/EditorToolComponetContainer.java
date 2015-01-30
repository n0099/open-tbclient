package com.baidu.tieba.tbadkCore.PbEditor;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.editortool.EmotionTabHost;
import com.baidu.tbadk.editortool.ToolMoreView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.imgView.DragContainer;
import com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView;
import com.baidu.tieba.tbadkCore.imgView.DragLayer;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class EditorToolComponetContainer extends RelativeLayout implements com.baidu.tieba.tbadkCore.imgView.d {
    protected LinearLayout MC;
    private com.baidu.tbadk.editortool.w Yj;
    private boolean Zs;
    protected ToolMoreView bVC;
    protected EmotionTabHost bVD;
    protected com.baidu.tieba.tbadkCore.voice.a bVE;
    protected com.baidu.tieba.tbadkCore.voice.f bVF;
    protected View bVG;
    protected View bVH;
    protected DragContainer bVI;
    protected DragLayer bVJ;
    protected DragHorizonScrollView bVK;
    protected DragContainer bVL;
    protected DragLayer bVM;
    protected DragHorizonScrollView bVN;
    protected TextView bVO;
    protected TextView bVP;
    protected as bVQ;
    protected boolean bVR;
    private AlertDialog.Builder bVS;
    private final boolean bVT;
    private boolean bVU;
    private int bVV;
    protected final bb bVW;
    private WriteImagesInfo bVX;
    private WriteImagesInfo bVY;
    private com.baidu.tbadk.img.e bVZ;
    protected Context mContext;
    private int padding;

    public EditorToolComponetContainer(Context context) {
        super(context);
        this.bVR = false;
        this.bVS = null;
        this.bVT = true;
        this.Zs = false;
        this.bVW = new bb();
        this.mContext = context;
        initialize();
    }

    public EditorToolComponetContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bVR = false;
        this.bVS = null;
        this.bVT = true;
        this.Zs = false;
        this.bVW = new bb();
        this.mContext = context;
        initialize();
    }

    protected void initialize() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.editor_tool_container, this, true);
        this.MC = (LinearLayout) findViewById(com.baidu.tieba.w.tools_container);
        this.bVC = (ToolMoreView) findViewById(com.baidu.tieba.w.tool_view);
        this.bVS = new AlertDialog.Builder(this.mContext);
        this.bVS.setTitle(com.baidu.tieba.z.editor_dialog_title);
        this.bVS.setNegativeButton(com.baidu.tieba.z.editor_dialog_no, (DialogInterface.OnClickListener) null);
        this.bVH = findViewById(com.baidu.tieba.w.pb_foot_down_shadow);
        if (a.afm() && this.bVC.getBaobao() != null && this.bVC.getBaobao().isShown()) {
            this.bVC.eg("N");
        }
    }

    private void afx() {
        if (this.bVE == null) {
            this.bVE = new com.baidu.tieba.tbadkCore.voice.a(this.mContext);
            this.MC.addView(this.bVE, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.pb_editor_faceview_height)));
            this.bVE.setVisibility(8);
            bc.i(this.bVE, com.baidu.tieba.t.record_voice_container_bg);
            if (this.bVF != null) {
                this.bVE.setCallback(this.bVF);
            }
            if (this.Yj != null) {
                this.Yj.handleAction(54, null);
            }
        }
    }

    private void afy() {
        if (this.bVD == null) {
            this.bVD = new EmotionTabHost(this.mContext);
            this.MC.addView(this.bVD, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.pb_editor_faceview_height)));
            this.bVD.setVisibility(8);
            this.bVD.setShowBigEmotion(!this.bVU);
            this.bVD.onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
            this.bVD.setOnDataSelected(new n(this));
        }
    }

    private void afz() {
        if (this.bVI == null) {
            com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.editor_tool_container_image, this.MC);
            this.bVI = (DragContainer) findViewById(com.baidu.tieba.w.muti_image_upload);
            this.bVJ = (DragLayer) findViewById(com.baidu.tieba.w.muti_image_upload_draglayer);
            this.bVK = (DragHorizonScrollView) findViewById(com.baidu.tieba.w.muti_image_upload_dragscrollview);
            com.baidu.tieba.tbadkCore.imgView.a aVar = new com.baidu.tieba.tbadkCore.imgView.a(getContext());
            aVar.a(this.bVJ);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.g) this.bVK);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.f) this.bVK);
            this.bVP = (TextView) findViewById(com.baidu.tieba.w.muti_image_tips);
            this.bVV = getResources().getDimensionPixelSize(com.baidu.tieba.u.editor_muti_image_upload_scrollview_paddingleft);
            this.padding = getResources().getDimensionPixelSize(com.baidu.tieba.u.default_gap_24);
            this.bVK.setAddView(hO(7));
            this.bVK.setOnSwapDataListener(this);
            this.bVK.setMaxItemNum(10);
            if (this.bVZ == null) {
                this.bVZ = new com.baidu.tbadk.img.e(this.mContext);
            }
        }
    }

    private void afA() {
        if (this.bVL == null) {
            com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.editor_tool_container_baobao, this.MC);
            this.bVL = (DragContainer) findViewById(com.baidu.tieba.w.baobao_image_upload);
            this.bVM = (DragLayer) findViewById(com.baidu.tieba.w.baobao_image_upload_draglayer);
            this.bVN = (DragHorizonScrollView) findViewById(com.baidu.tieba.w.baobao_image_upload_dragscrollview);
            this.bVO = (TextView) findViewById(com.baidu.tieba.w.baobao_image_tips);
            com.baidu.tieba.tbadkCore.imgView.a aVar = new com.baidu.tieba.tbadkCore.imgView.a(getContext());
            aVar.a(this.bVM);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.g) this.bVN);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.f) this.bVN);
            this.bVN.setAddView(hO(48));
            this.bVN.setOnSwapDataListener(this);
            this.bVN.setMaxItemNum(1);
            this.bVN.setCenterStart(true);
            if (this.bVZ == null) {
                this.bVZ = new com.baidu.tbadk.img.e(this.mContext);
            }
        }
    }

    private void afB() {
        if (this.bVQ == null) {
            this.bVQ = new as(this.mContext);
            this.MC.addView(this.bVQ, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.pb_editor_faceview_height)));
            this.bVQ.setVisibility(8);
            this.bVQ.onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
            this.bVQ.setOnDataSelected(new o(this));
        }
    }

    protected void afC() {
        com.baidu.adp.base.l B = com.baidu.adp.base.m.B(this.mContext);
        if (B != null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2010041, this.bVW);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2010041, B.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessageToUI(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afD() {
        if (afY()) {
            this.bVW.bXh = 1;
        } else {
            this.bVW.bXh = 0;
        }
        if (this.bVX != null && this.bVX.getChosedFiles() != null && this.bVX.getChosedFiles().size() > 0) {
            this.bVW.bXg = this.bVX.getChosedFiles().size();
        } else {
            this.bVW.bXg = 0;
        }
        if (this.bVY != null && this.bVY.getChosedFiles() != null && this.bVY.getChosedFiles().size() > 0) {
            this.bVW.bXi = this.bVY.getChosedFiles().size();
        } else {
            this.bVW.bXi = 0;
        }
        afC();
    }

    public void setHideBaobao(boolean z) {
        this.Zs = z;
        if (this.bVC != null) {
            this.bVC.setHideBaobao(z);
            if (z && a.afm()) {
                this.bVC.vE();
            }
        }
    }

    public void setShadowBackground(int i) {
        if (this.bVH != null) {
            bc.j(this.bVH, i);
        }
    }

    public void setShadowHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (i > 0 && (layoutParams = this.bVH.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.bVH.setLayoutParams(layoutParams);
        }
    }

    public void setFrom(int i) {
        if (this.bVD != null) {
            this.bVD.setFrom(i);
        }
    }

    protected void afE() {
        afy();
        this.bVH.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().getKeyboardHeight() > 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVD.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m255getInst().getKeyboardHeight();
            this.bVD.setLayoutParams(layoutParams);
        }
        this.bVD.setVisibility(0);
    }

    protected void afF() {
        if (this.bVD != null) {
            this.bVD.setVisibility(8);
        }
    }

    protected void YU() {
        afx();
        this.bVH.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVE.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m255getInst().getKeyboardHeight();
            this.bVE.setLayoutParams(layoutParams);
        }
        this.bVE.setVisibility(0);
    }

    protected void YT() {
        if (this.bVE != null) {
            this.bVE.setVisibility(8);
        }
    }

    protected void afG() {
        this.bVH.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVC.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m255getInst().getKeyboardHeight();
            this.bVC.setLayoutParams(layoutParams);
        }
        this.bVC.setVisibility(0);
    }

    public void afH() {
        if (this.bVI != null) {
            this.bVI.setVisibility(8);
        }
    }

    public void afI() {
        afz();
        this.bVH.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVI.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m255getInst().getKeyboardHeight();
            this.bVI.setLayoutParams(layoutParams);
        }
        this.bVI.setVisibility(0);
    }

    public void afJ() {
        if (this.bVL != null) {
            this.bVL.setVisibility(8);
        }
    }

    public void vE() {
        this.bVC.vE();
    }

    public void ee(String str) {
        if (this.bVC != null) {
            this.bVC.ee(str);
        }
    }

    public void vx() {
        if (this.bVC != null) {
            this.bVC.vx();
        }
    }

    public void vF() {
        if (this.bVC != null) {
            this.bVC.vF();
        }
    }

    public void vG() {
        if (this.bVC != null) {
            this.bVC.vG();
        }
    }

    public boolean vB() {
        if (this.bVC == null) {
            return false;
        }
        return this.bVC.vB();
    }

    public void vC() {
        if (this.bVC != null) {
            this.bVC.vC();
        }
    }

    public void vD() {
        if (this.bVC != null) {
            this.bVC.vD();
        }
    }

    public void afK() {
        afA();
        this.bVH.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVL.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m255getInst().getKeyboardHeight();
            this.bVL.setLayoutParams(layoutParams);
        }
        this.bVL.setVisibility(0);
        if (TextUtils.isEmpty(this.bVO.getText())) {
            this.bVO.setText(com.baidu.tieba.z.baobao_remind);
        }
    }

    protected void hideMore() {
        this.bVC.setVisibility(8);
    }

    protected void afL() {
        afB();
        this.bVH.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVQ.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m255getInst().getKeyboardHeight();
            this.bVQ.setLayoutParams(layoutParams);
        }
        this.bVQ.setVisibility(0);
    }

    protected void afM() {
        if (this.bVQ != null) {
            this.bVQ.setVisibility(8);
        }
    }

    public void V(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.l.d(this.mContext, view);
            this.bVR = true;
        }
    }

    public void W(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.l.c(this.mContext, view);
            this.bVR = false;
        }
    }

    public boolean afN() {
        return this.bVC.getVisibility() == 0 || (this.bVE != null && this.bVE.getVisibility() == 0) || ((this.bVD != null && this.bVD.getVisibility() == 0) || ((this.bVI != null && this.bVI.getVisibility() == 0) || ((this.bVQ != null && this.bVQ.getVisibility() == 0) || (this.bVL != null && this.bVL.getVisibility() == 0))));
    }

    public void hideAll() {
        afO();
        W(this.bVG);
    }

    public void afO() {
        this.bVH.setVisibility(8);
        hideMore();
        YT();
        afF();
        afH();
        afM();
        afJ();
    }

    public void afP() {
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanUsed()) {
            if (this.bVC != null && this.bVC.getVisibility() == 0) {
                afG();
            } else if (this.bVD != null && this.bVD.getVisibility() == 0) {
                afE();
            } else if (this.bVE != null && this.bVE.getVisibility() == 0) {
                YU();
            } else if (this.bVI != null && this.bVI.getVisibility() == 0) {
                afI();
            } else if (this.bVQ != null && this.bVQ.getVisibility() == 0) {
                afL();
            } else if (this.bVL != null && this.bVL.getVisibility() == 0) {
                afK();
            }
        }
    }

    public void afQ() {
        hideAll();
        afG();
    }

    public void afR() {
        hideAll();
        afE();
    }

    public void afS() {
        hideAll();
        YU();
    }

    public void afT() {
        hideAll();
        afI();
    }

    public void afU() {
        hideAll();
        afL();
    }

    public void afV() {
        hideAll();
        afK();
    }

    public void X(View view) {
        if (!this.bVR) {
            hideAll();
            this.bVG = view;
            V(view);
        }
    }

    public boolean afW() {
        BaseAdapter adapter;
        return (this.bVK == null || (adapter = this.bVK.getAdapter()) == null || adapter.getCount() <= 0) ? false : true;
    }

    public boolean afX() {
        BaseAdapter adapter;
        return (this.bVN == null || (adapter = this.bVN.getAdapter()) == null || adapter.getCount() <= 0) ? false : true;
    }

    public boolean afY() {
        VoiceData.VoiceModel voiceModel;
        return (this.bVE == null || (voiceModel = this.bVE.getVoiceModel()) == null || voiceModel.getId() == null || voiceModel.getId().length() <= 0) ? false : true;
    }

    public VoiceData.VoiceModel getAudioData() {
        if (this.bVE == null) {
            return null;
        }
        return this.bVE.getVoiceModel();
    }

    public void afZ() {
        if (this.bVF != null) {
            this.bVF.agd();
        }
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        if (this.bVE != null && voiceModel != null) {
            this.bVE.c(voiceModel);
        }
    }

    public void FN() {
        if (this.bVE != null) {
            this.bVE.aiE();
        }
    }

    public void clearData() {
        if (this.bVE != null) {
            this.bVE.reset();
            setImage(null);
            this.bVC.vE();
        }
    }

    public void FO() {
        if (this.bVE != null) {
            this.bVE.onStopingRecorder();
        }
    }

    public void aga() {
        FO();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        this.Yj = new p(this, wVar);
        this.bVS.setPositiveButton(com.baidu.tieba.z.editor_dialog_yes, new q(this));
        this.bVC.setOnClickListener(new r(this));
        this.bVF = new s(this);
        if (this.bVE != null) {
            this.bVE.setCallback(this.bVF);
        }
    }

    public boolean agb() {
        return this.bVR;
    }

    public void setImage(Bitmap bitmap) {
        if (bitmap == null) {
            this.bVC.setmImagetype(0);
        }
        this.bVC.setImage(bitmap);
    }

    public void aK(boolean z) {
        this.bVU = z;
        this.bVC.aK(z);
        if (this.bVD != null) {
            this.bVD.setShowBigEmotion(!z);
        }
    }

    public void vI() {
        this.bVC.vI();
    }

    public void vJ() {
        this.bVC.vJ();
    }

    public void onChangeSkinType(int i) {
        if (this.bVD != null) {
            this.bVD.onChangeSkinType(i);
        }
        this.bVC.onChangeSkinType(i);
        if (this.bVQ != null) {
            this.bVQ.onChangeSkinType(i);
        }
        if (this.bVE != null) {
            bc.i(this.bVE, com.baidu.tieba.t.record_voice_container_bg);
        }
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        afz();
        this.bVX = writeImagesInfo;
        this.bVK.a(new u(this, writeImagesInfo), z);
        int maxItemNum = this.bVK.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (!com.baidu.tieba.tbadkCore.as.agM().agN() && size > 1) {
            this.bVP.setText(com.baidu.tieba.z.editor_mutiiamge_drag_tip);
            com.baidu.tieba.tbadkCore.as.agM().eA(true);
        } else {
            this.bVP.setText(getResources().getString(com.baidu.tieba.z.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
        }
        if (size > 0) {
            this.bVC.ee(new StringBuilder(String.valueOf(size)).toString());
        } else {
            this.bVC.vx();
        }
        this.Yj.handleAction(13, null);
        afD();
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        afA();
        this.bVY = writeImagesInfo;
        this.bVN.a((BaseAdapter) new u(this, this.bVY), false);
        this.Yj.handleAction(51, null);
        if (this.bVY.size() > 0) {
            this.bVC.eg("1");
        } else {
            this.bVC.vE();
        }
        this.Yj.handleAction(51, null);
        afD();
    }

    private View hO(int i) {
        TbadkCoreApplication.m255getInst().getSkinType();
        ImageView imageView = new ImageView(getContext());
        bc.c(imageView, com.baidu.tieba.v.btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        int dip2px = com.baidu.adp.lib.util.l.dip2px(this.mContext, 3.0f);
        imageView.setPadding(dip2px, com.baidu.adp.lib.util.l.dip2px(this.mContext, 1.0f) + getResources().getDimensionPixelSize(com.baidu.tieba.u.default_gap_20) + dip2px, this.padding + dip2px, dip2px);
        imageView.setOnClickListener(new t(this, i));
        return imageView;
    }

    public void agc() {
        if (this.bVK != null) {
            this.bVK.notifyDataSetChanged();
        }
        if (this.bVN != null) {
            this.bVN.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void ab(int i, int i2) {
        if (i != i2 && this.bVX != null && this.bVX.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.bVX.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void refresh() {
        if (this.bVU) {
            this.bVC.vA();
        } else if (TextUtils.isEmpty(TbadkCoreApplication.m255getInst().getDefaultBubble()) && !this.bVU) {
            this.bVC.vA();
        } else {
            this.bVC.vz();
        }
    }
}
