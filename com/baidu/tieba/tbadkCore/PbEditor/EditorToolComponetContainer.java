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
    protected LinearLayout Mz;
    private com.baidu.tbadk.editortool.w Yg;
    private boolean Zp;
    protected ToolMoreView bVB;
    protected EmotionTabHost bVC;
    protected com.baidu.tieba.tbadkCore.voice.a bVD;
    protected com.baidu.tieba.tbadkCore.voice.f bVE;
    protected View bVF;
    protected View bVG;
    protected DragContainer bVH;
    protected DragLayer bVI;
    protected DragHorizonScrollView bVJ;
    protected DragContainer bVK;
    protected DragLayer bVL;
    protected DragHorizonScrollView bVM;
    protected TextView bVN;
    protected TextView bVO;
    protected as bVP;
    protected boolean bVQ;
    private AlertDialog.Builder bVR;
    private final boolean bVS;
    private boolean bVT;
    private int bVU;
    protected final bb bVV;
    private WriteImagesInfo bVW;
    private WriteImagesInfo bVX;
    private com.baidu.tbadk.img.e bVY;
    protected Context mContext;
    private int padding;

    public EditorToolComponetContainer(Context context) {
        super(context);
        this.bVQ = false;
        this.bVR = null;
        this.bVS = true;
        this.Zp = false;
        this.bVV = new bb();
        this.mContext = context;
        initialize();
    }

    public EditorToolComponetContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bVQ = false;
        this.bVR = null;
        this.bVS = true;
        this.Zp = false;
        this.bVV = new bb();
        this.mContext = context;
        initialize();
    }

    protected void initialize() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.editor_tool_container, this, true);
        this.Mz = (LinearLayout) findViewById(com.baidu.tieba.w.tools_container);
        this.bVB = (ToolMoreView) findViewById(com.baidu.tieba.w.tool_view);
        this.bVR = new AlertDialog.Builder(this.mContext);
        this.bVR.setTitle(com.baidu.tieba.z.editor_dialog_title);
        this.bVR.setNegativeButton(com.baidu.tieba.z.editor_dialog_no, (DialogInterface.OnClickListener) null);
        this.bVG = findViewById(com.baidu.tieba.w.pb_foot_down_shadow);
        if (a.afh() && this.bVB.getBaobao() != null && this.bVB.getBaobao().isShown()) {
            this.bVB.ed("N");
        }
    }

    private void afs() {
        if (this.bVD == null) {
            this.bVD = new com.baidu.tieba.tbadkCore.voice.a(this.mContext);
            this.Mz.addView(this.bVD, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.pb_editor_faceview_height)));
            this.bVD.setVisibility(8);
            bc.i(this.bVD, com.baidu.tieba.t.record_voice_container_bg);
            if (this.bVE != null) {
                this.bVD.setCallback(this.bVE);
            }
            if (this.Yg != null) {
                this.Yg.handleAction(54, null);
            }
        }
    }

    private void aft() {
        if (this.bVC == null) {
            this.bVC = new EmotionTabHost(this.mContext);
            this.Mz.addView(this.bVC, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.pb_editor_faceview_height)));
            this.bVC.setVisibility(8);
            this.bVC.setShowBigEmotion(!this.bVT);
            this.bVC.onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
            this.bVC.setOnDataSelected(new n(this));
        }
    }

    private void afu() {
        if (this.bVH == null) {
            com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.editor_tool_container_image, this.Mz);
            this.bVH = (DragContainer) findViewById(com.baidu.tieba.w.muti_image_upload);
            this.bVI = (DragLayer) findViewById(com.baidu.tieba.w.muti_image_upload_draglayer);
            this.bVJ = (DragHorizonScrollView) findViewById(com.baidu.tieba.w.muti_image_upload_dragscrollview);
            com.baidu.tieba.tbadkCore.imgView.a aVar = new com.baidu.tieba.tbadkCore.imgView.a(getContext());
            aVar.a(this.bVI);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.g) this.bVJ);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.f) this.bVJ);
            this.bVO = (TextView) findViewById(com.baidu.tieba.w.muti_image_tips);
            this.bVU = getResources().getDimensionPixelSize(com.baidu.tieba.u.editor_muti_image_upload_scrollview_paddingleft);
            this.padding = getResources().getDimensionPixelSize(com.baidu.tieba.u.default_gap_24);
            this.bVJ.setAddView(hO(7));
            this.bVJ.setOnSwapDataListener(this);
            this.bVJ.setMaxItemNum(10);
            if (this.bVY == null) {
                this.bVY = new com.baidu.tbadk.img.e(this.mContext);
            }
        }
    }

    private void afv() {
        if (this.bVK == null) {
            com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.editor_tool_container_baobao, this.Mz);
            this.bVK = (DragContainer) findViewById(com.baidu.tieba.w.baobao_image_upload);
            this.bVL = (DragLayer) findViewById(com.baidu.tieba.w.baobao_image_upload_draglayer);
            this.bVM = (DragHorizonScrollView) findViewById(com.baidu.tieba.w.baobao_image_upload_dragscrollview);
            this.bVN = (TextView) findViewById(com.baidu.tieba.w.baobao_image_tips);
            com.baidu.tieba.tbadkCore.imgView.a aVar = new com.baidu.tieba.tbadkCore.imgView.a(getContext());
            aVar.a(this.bVL);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.g) this.bVM);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.f) this.bVM);
            this.bVM.setAddView(hO(48));
            this.bVM.setOnSwapDataListener(this);
            this.bVM.setMaxItemNum(1);
            this.bVM.setCenterStart(true);
            if (this.bVY == null) {
                this.bVY = new com.baidu.tbadk.img.e(this.mContext);
            }
        }
    }

    private void afw() {
        if (this.bVP == null) {
            this.bVP = new as(this.mContext);
            this.Mz.addView(this.bVP, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.pb_editor_faceview_height)));
            this.bVP.setVisibility(8);
            this.bVP.onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
            this.bVP.setOnDataSelected(new o(this));
        }
    }

    protected void afx() {
        com.baidu.adp.base.l B = com.baidu.adp.base.m.B(this.mContext);
        if (B != null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2010041, this.bVV);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2010041, B.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessageToUI(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afy() {
        if (afT()) {
            this.bVV.bXg = 1;
        } else {
            this.bVV.bXg = 0;
        }
        if (this.bVW != null && this.bVW.getChosedFiles() != null && this.bVW.getChosedFiles().size() > 0) {
            this.bVV.bXf = this.bVW.getChosedFiles().size();
        } else {
            this.bVV.bXf = 0;
        }
        if (this.bVX != null && this.bVX.getChosedFiles() != null && this.bVX.getChosedFiles().size() > 0) {
            this.bVV.bXh = this.bVX.getChosedFiles().size();
        } else {
            this.bVV.bXh = 0;
        }
        afx();
    }

    public void setHideBaobao(boolean z) {
        this.Zp = z;
        if (this.bVB != null) {
            this.bVB.setHideBaobao(z);
            if (z && a.afh()) {
                this.bVB.vy();
            }
        }
    }

    public void setShadowBackground(int i) {
        if (this.bVG != null) {
            bc.j(this.bVG, i);
        }
    }

    public void setShadowHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (i > 0 && (layoutParams = this.bVG.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.bVG.setLayoutParams(layoutParams);
        }
    }

    public void setFrom(int i) {
        if (this.bVC != null) {
            this.bVC.setFrom(i);
        }
    }

    protected void afz() {
        aft();
        this.bVG.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().getKeyboardHeight() > 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVC.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m255getInst().getKeyboardHeight();
            this.bVC.setLayoutParams(layoutParams);
        }
        this.bVC.setVisibility(0);
    }

    protected void afA() {
        if (this.bVC != null) {
            this.bVC.setVisibility(8);
        }
    }

    protected void YP() {
        afs();
        this.bVG.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVD.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m255getInst().getKeyboardHeight();
            this.bVD.setLayoutParams(layoutParams);
        }
        this.bVD.setVisibility(0);
    }

    protected void YO() {
        if (this.bVD != null) {
            this.bVD.setVisibility(8);
        }
    }

    protected void afB() {
        this.bVG.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVB.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m255getInst().getKeyboardHeight();
            this.bVB.setLayoutParams(layoutParams);
        }
        this.bVB.setVisibility(0);
    }

    public void afC() {
        if (this.bVH != null) {
            this.bVH.setVisibility(8);
        }
    }

    public void afD() {
        afu();
        this.bVG.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVH.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m255getInst().getKeyboardHeight();
            this.bVH.setLayoutParams(layoutParams);
        }
        this.bVH.setVisibility(0);
    }

    public void afE() {
        if (this.bVK != null) {
            this.bVK.setVisibility(8);
        }
    }

    public void vy() {
        this.bVB.vy();
    }

    public void eb(String str) {
        if (this.bVB != null) {
            this.bVB.eb(str);
        }
    }

    public void vr() {
        if (this.bVB != null) {
            this.bVB.vr();
        }
    }

    public void vz() {
        if (this.bVB != null) {
            this.bVB.vz();
        }
    }

    public void vA() {
        if (this.bVB != null) {
            this.bVB.vA();
        }
    }

    public boolean vv() {
        if (this.bVB == null) {
            return false;
        }
        return this.bVB.vv();
    }

    public void vw() {
        if (this.bVB != null) {
            this.bVB.vw();
        }
    }

    public void vx() {
        if (this.bVB != null) {
            this.bVB.vx();
        }
    }

    public void afF() {
        afv();
        this.bVG.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVK.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m255getInst().getKeyboardHeight();
            this.bVK.setLayoutParams(layoutParams);
        }
        this.bVK.setVisibility(0);
        if (TextUtils.isEmpty(this.bVN.getText())) {
            this.bVN.setText(com.baidu.tieba.z.baobao_remind);
        }
    }

    protected void hideMore() {
        this.bVB.setVisibility(8);
    }

    protected void afG() {
        afw();
        this.bVG.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bVP.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m255getInst().getKeyboardHeight();
            this.bVP.setLayoutParams(layoutParams);
        }
        this.bVP.setVisibility(0);
    }

    protected void afH() {
        if (this.bVP != null) {
            this.bVP.setVisibility(8);
        }
    }

    public void V(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.l.d(this.mContext, view);
            this.bVQ = true;
        }
    }

    public void W(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.l.c(this.mContext, view);
            this.bVQ = false;
        }
    }

    public boolean afI() {
        return this.bVB.getVisibility() == 0 || (this.bVD != null && this.bVD.getVisibility() == 0) || ((this.bVC != null && this.bVC.getVisibility() == 0) || ((this.bVH != null && this.bVH.getVisibility() == 0) || ((this.bVP != null && this.bVP.getVisibility() == 0) || (this.bVK != null && this.bVK.getVisibility() == 0))));
    }

    public void hideAll() {
        afJ();
        W(this.bVF);
    }

    public void afJ() {
        this.bVG.setVisibility(8);
        hideMore();
        YO();
        afA();
        afC();
        afH();
        afE();
    }

    public void afK() {
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanUsed()) {
            if (this.bVB != null && this.bVB.getVisibility() == 0) {
                afB();
            } else if (this.bVC != null && this.bVC.getVisibility() == 0) {
                afz();
            } else if (this.bVD != null && this.bVD.getVisibility() == 0) {
                YP();
            } else if (this.bVH != null && this.bVH.getVisibility() == 0) {
                afD();
            } else if (this.bVP != null && this.bVP.getVisibility() == 0) {
                afG();
            } else if (this.bVK != null && this.bVK.getVisibility() == 0) {
                afF();
            }
        }
    }

    public void afL() {
        hideAll();
        afB();
    }

    public void afM() {
        hideAll();
        afz();
    }

    public void afN() {
        hideAll();
        YP();
    }

    public void afO() {
        hideAll();
        afD();
    }

    public void afP() {
        hideAll();
        afG();
    }

    public void afQ() {
        hideAll();
        afF();
    }

    public void X(View view) {
        if (!this.bVQ) {
            hideAll();
            this.bVF = view;
            V(view);
        }
    }

    public boolean afR() {
        BaseAdapter adapter;
        return (this.bVJ == null || (adapter = this.bVJ.getAdapter()) == null || adapter.getCount() <= 0) ? false : true;
    }

    public boolean afS() {
        BaseAdapter adapter;
        return (this.bVM == null || (adapter = this.bVM.getAdapter()) == null || adapter.getCount() <= 0) ? false : true;
    }

    public boolean afT() {
        VoiceData.VoiceModel voiceModel;
        return (this.bVD == null || (voiceModel = this.bVD.getVoiceModel()) == null || voiceModel.getId() == null || voiceModel.getId().length() <= 0) ? false : true;
    }

    public VoiceData.VoiceModel getAudioData() {
        if (this.bVD == null) {
            return null;
        }
        return this.bVD.getVoiceModel();
    }

    public void afU() {
        if (this.bVE != null) {
            this.bVE.afY();
        }
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        if (this.bVD != null && voiceModel != null) {
            this.bVD.c(voiceModel);
        }
    }

    public void FH() {
        if (this.bVD != null) {
            this.bVD.aiz();
        }
    }

    public void clearData() {
        if (this.bVD != null) {
            this.bVD.reset();
            setImage(null);
            this.bVB.vy();
        }
    }

    public void FI() {
        if (this.bVD != null) {
            this.bVD.onStopingRecorder();
        }
    }

    public void afV() {
        FI();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        this.Yg = new p(this, wVar);
        this.bVR.setPositiveButton(com.baidu.tieba.z.editor_dialog_yes, new q(this));
        this.bVB.setOnClickListener(new r(this));
        this.bVE = new s(this);
        if (this.bVD != null) {
            this.bVD.setCallback(this.bVE);
        }
    }

    public boolean afW() {
        return this.bVQ;
    }

    public void setImage(Bitmap bitmap) {
        if (bitmap == null) {
            this.bVB.setmImagetype(0);
        }
        this.bVB.setImage(bitmap);
    }

    public void aK(boolean z) {
        this.bVT = z;
        this.bVB.aK(z);
        if (this.bVC != null) {
            this.bVC.setShowBigEmotion(!z);
        }
    }

    public void vC() {
        this.bVB.vC();
    }

    public void vD() {
        this.bVB.vD();
    }

    public void onChangeSkinType(int i) {
        if (this.bVC != null) {
            this.bVC.onChangeSkinType(i);
        }
        this.bVB.onChangeSkinType(i);
        if (this.bVP != null) {
            this.bVP.onChangeSkinType(i);
        }
        if (this.bVD != null) {
            bc.i(this.bVD, com.baidu.tieba.t.record_voice_container_bg);
        }
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        afu();
        this.bVW = writeImagesInfo;
        this.bVJ.a(new u(this, writeImagesInfo), z);
        int maxItemNum = this.bVJ.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (!com.baidu.tieba.tbadkCore.as.agH().agI() && size > 1) {
            this.bVO.setText(com.baidu.tieba.z.editor_mutiiamge_drag_tip);
            com.baidu.tieba.tbadkCore.as.agH().eA(true);
        } else {
            this.bVO.setText(getResources().getString(com.baidu.tieba.z.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
        }
        if (size > 0) {
            this.bVB.eb(new StringBuilder(String.valueOf(size)).toString());
        } else {
            this.bVB.vr();
        }
        this.Yg.handleAction(13, null);
        afy();
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        afv();
        this.bVX = writeImagesInfo;
        this.bVM.a((BaseAdapter) new u(this, this.bVX), false);
        this.Yg.handleAction(51, null);
        if (this.bVX.size() > 0) {
            this.bVB.ed("1");
        } else {
            this.bVB.vy();
        }
        this.Yg.handleAction(51, null);
        afy();
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

    public void afX() {
        if (this.bVJ != null) {
            this.bVJ.notifyDataSetChanged();
        }
        if (this.bVM != null) {
            this.bVM.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void ac(int i, int i2) {
        if (i != i2 && this.bVW != null && this.bVW.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.bVW.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void refresh() {
        if (this.bVT) {
            this.bVB.vu();
        } else if (TextUtils.isEmpty(TbadkCoreApplication.m255getInst().getDefaultBubble()) && !this.bVT) {
            this.bVB.vu();
        } else {
            this.bVB.vt();
        }
    }
}
