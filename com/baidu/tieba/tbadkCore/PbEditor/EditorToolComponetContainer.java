package com.baidu.tieba.tbadkCore.PbEditor;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
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
    protected LinearLayout Mg;
    private com.baidu.tbadk.editortool.w XD;
    private boolean YZ;
    protected ToolMoreView bTK;
    protected EmotionTabHost bTL;
    protected com.baidu.tieba.tbadkCore.voice.a bTM;
    protected com.baidu.tieba.tbadkCore.voice.f bTN;
    protected View bTO;
    protected ImageView bTP;
    protected DragContainer bTQ;
    protected DragLayer bTR;
    protected DragHorizonScrollView bTS;
    protected DragContainer bTT;
    protected DragLayer bTU;
    protected DragHorizonScrollView bTV;
    protected TextView bTW;
    protected TextView bTX;
    protected as bTY;
    protected boolean bTZ;
    private AlertDialog.Builder bUa;
    private final boolean bUb;
    private boolean bUc;
    private int bUd;
    protected final bb bUe;
    private WriteImagesInfo bUf;
    private WriteImagesInfo bUg;
    private com.baidu.tbadk.img.e bUh;
    protected Context mContext;
    private int padding;

    public EditorToolComponetContainer(Context context) {
        super(context);
        this.bTZ = false;
        this.bUa = null;
        this.bUb = true;
        this.YZ = false;
        this.bUe = new bb();
        this.mContext = context;
        initialize();
    }

    public EditorToolComponetContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTZ = false;
        this.bUa = null;
        this.bUb = true;
        this.YZ = false;
        this.bUe = new bb();
        this.mContext = context;
        initialize();
    }

    protected void initialize() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.x.editor_tool_container, this, true);
        this.Mg = (LinearLayout) findViewById(com.baidu.tieba.w.tools_container);
        this.bTK = (ToolMoreView) findViewById(com.baidu.tieba.w.tool_view);
        this.bUa = new AlertDialog.Builder(this.mContext);
        this.bUa.setTitle(com.baidu.tieba.z.editor_dialog_title);
        this.bUa.setNegativeButton(com.baidu.tieba.z.editor_dialog_no, (DialogInterface.OnClickListener) null);
        this.bTP = (ImageView) findViewById(com.baidu.tieba.w.pb_foot_down_shadow);
        if (a.aeI() && this.bTK.getBaobao() != null && this.bTK.getBaobao().isShown()) {
            this.bTK.eg("N");
        }
    }

    private void aeT() {
        if (this.bTM == null) {
            this.bTM = new com.baidu.tieba.tbadkCore.voice.a(this.mContext);
            this.Mg.addView(this.bTM, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.pb_editor_faceview_height)));
            this.bTM.setVisibility(8);
            com.baidu.tbadk.core.util.ax.i(this.bTM, com.baidu.tieba.t.record_voice_container_bg);
            if (this.bTN != null) {
                this.bTM.setCallback(this.bTN);
            }
            if (this.XD != null) {
                this.XD.handleAction(54, null);
            }
        }
    }

    private void aeU() {
        if (this.bTL == null) {
            this.bTL = new EmotionTabHost(this.mContext);
            this.Mg.addView(this.bTL, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.pb_editor_faceview_height)));
            this.bTL.setVisibility(8);
            this.bTL.setShowBigEmotion(!this.bUc);
            this.bTL.onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
            this.bTL.setOnDataSelected(new n(this));
        }
    }

    private void aeV() {
        if (this.bTQ == null) {
            com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.editor_tool_container_image, this.Mg);
            this.bTQ = (DragContainer) findViewById(com.baidu.tieba.w.muti_image_upload);
            this.bTR = (DragLayer) findViewById(com.baidu.tieba.w.muti_image_upload_draglayer);
            this.bTS = (DragHorizonScrollView) findViewById(com.baidu.tieba.w.muti_image_upload_dragscrollview);
            com.baidu.tieba.tbadkCore.imgView.a aVar = new com.baidu.tieba.tbadkCore.imgView.a(getContext());
            aVar.a(this.bTR);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.g) this.bTS);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.f) this.bTS);
            this.bTX = (TextView) findViewById(com.baidu.tieba.w.muti_image_tips);
            this.bUd = getResources().getDimensionPixelSize(com.baidu.tieba.u.editor_muti_image_upload_scrollview_paddingleft);
            this.padding = getResources().getDimensionPixelSize(com.baidu.tieba.u.default_gap_24);
            this.bTS.setAddView(hF(7));
            this.bTS.setOnSwapDataListener(this);
            this.bTS.setMaxItemNum(10);
            if (this.bUh == null) {
                this.bUh = new com.baidu.tbadk.img.e(this.mContext);
            }
        }
    }

    private void aeW() {
        if (this.bTT == null) {
            com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.editor_tool_container_baobao, this.Mg);
            this.bTT = (DragContainer) findViewById(com.baidu.tieba.w.baobao_image_upload);
            this.bTU = (DragLayer) findViewById(com.baidu.tieba.w.baobao_image_upload_draglayer);
            this.bTV = (DragHorizonScrollView) findViewById(com.baidu.tieba.w.baobao_image_upload_dragscrollview);
            this.bTW = (TextView) findViewById(com.baidu.tieba.w.baobao_image_tips);
            com.baidu.tieba.tbadkCore.imgView.a aVar = new com.baidu.tieba.tbadkCore.imgView.a(getContext());
            aVar.a(this.bTU);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.g) this.bTV);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.f) this.bTV);
            this.bTV.setAddView(hF(48));
            this.bTV.setOnSwapDataListener(this);
            this.bTV.setMaxItemNum(1);
            this.bTV.setCenterStart(true);
            if (this.bUh == null) {
                this.bUh = new com.baidu.tbadk.img.e(this.mContext);
            }
        }
    }

    private void aeX() {
        if (this.bTY == null) {
            this.bTY = new as(this.mContext);
            this.Mg.addView(this.bTY, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.u.pb_editor_faceview_height)));
            this.bTY.setVisibility(8);
            this.bTY.onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
            this.bTY.setOnDataSelected(new o(this));
        }
    }

    protected void aeY() {
        com.baidu.adp.base.l B = com.baidu.adp.base.m.B(this.mContext);
        if (B != null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2010041, this.bUe);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2010041, B.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessageToUI(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aeZ() {
        if (afu()) {
            this.bUe.bVp = 1;
        } else {
            this.bUe.bVp = 0;
        }
        if (this.bUf != null && this.bUf.getChosedFiles() != null && this.bUf.getChosedFiles().size() > 0) {
            this.bUe.bVo = this.bUf.getChosedFiles().size();
        } else {
            this.bUe.bVo = 0;
        }
        if (this.bUg != null && this.bUg.getChosedFiles() != null && this.bUg.getChosedFiles().size() > 0) {
            this.bUe.bVq = this.bUg.getChosedFiles().size();
        } else {
            this.bUe.bVq = 0;
        }
        aeY();
    }

    public void setHideBaobao(boolean z) {
        this.YZ = z;
        if (this.bTK != null) {
            this.bTK.setHideBaobao(z);
            if (z && a.aeI()) {
                this.bTK.vn();
            }
        }
    }

    public void setFrom(int i) {
        if (this.bTL != null) {
            this.bTL.setFrom(i);
        }
    }

    protected void afa() {
        aeU();
        this.bTP.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().getKeyboardHeight() > 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTL.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m255getInst().getKeyboardHeight();
            this.bTL.setLayoutParams(layoutParams);
        }
        this.bTL.setVisibility(0);
    }

    protected void afb() {
        if (this.bTL != null) {
            this.bTL.setVisibility(8);
        }
    }

    public void Wy() {
        View recordButton;
        if (this.bTK != null && (recordButton = this.bTK.getRecordButton()) != null) {
            recordButton.setVisibility(4);
        }
    }

    public void Wz() {
        View recordButton;
        if (this.bTK != null && (recordButton = this.bTK.getRecordButton()) != null) {
            recordButton.setVisibility(0);
        }
    }

    protected void Yp() {
        aeT();
        this.bTP.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTM.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m255getInst().getKeyboardHeight();
            this.bTM.setLayoutParams(layoutParams);
        }
        this.bTM.setVisibility(0);
    }

    protected void Yo() {
        if (this.bTM != null) {
            this.bTM.setVisibility(8);
        }
    }

    protected void afc() {
        this.bTP.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTK.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m255getInst().getKeyboardHeight();
            this.bTK.setLayoutParams(layoutParams);
        }
        this.bTK.setVisibility(0);
    }

    public void afd() {
        if (this.bTQ != null) {
            this.bTQ.setVisibility(8);
        }
    }

    public void afe() {
        aeV();
        this.bTP.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTQ.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m255getInst().getKeyboardHeight();
            this.bTQ.setLayoutParams(layoutParams);
        }
        this.bTQ.setVisibility(0);
    }

    public void aff() {
        if (this.bTT != null) {
            this.bTT.setVisibility(8);
        }
    }

    public void vn() {
        this.bTK.vn();
    }

    public void ee(String str) {
        if (this.bTK != null) {
            this.bTK.ee(str);
        }
    }

    public void vg() {
        if (this.bTK != null) {
            this.bTK.vg();
        }
    }

    public void vo() {
        if (this.bTK != null) {
            this.bTK.vo();
        }
    }

    public void vp() {
        if (this.bTK != null) {
            this.bTK.vp();
        }
    }

    public boolean vk() {
        if (this.bTK == null) {
            return false;
        }
        return this.bTK.vk();
    }

    public void vl() {
        if (this.bTK != null) {
            this.bTK.vl();
        }
    }

    public void vm() {
        if (this.bTK != null) {
            this.bTK.vm();
        }
    }

    public void afg() {
        aeW();
        this.bTP.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTT.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m255getInst().getKeyboardHeight();
            this.bTT.setLayoutParams(layoutParams);
        }
        this.bTT.setVisibility(0);
        if (TextUtils.isEmpty(this.bTW.getText())) {
            this.bTW.setText(com.baidu.tieba.z.baobao_remind);
        }
    }

    protected void hideMore() {
        this.bTK.setVisibility(8);
    }

    protected void afh() {
        aeX();
        this.bTP.setVisibility(0);
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bTY.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m255getInst().getKeyboardHeight();
            this.bTY.setLayoutParams(layoutParams);
        }
        this.bTY.setVisibility(0);
    }

    protected void afi() {
        if (this.bTY != null) {
            this.bTY.setVisibility(8);
        }
    }

    public void T(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.l.d(this.mContext, view);
            this.bTZ = true;
        }
    }

    public void U(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.l.c(this.mContext, view);
            this.bTZ = false;
        }
    }

    public boolean afj() {
        return this.bTK.getVisibility() == 0 || (this.bTM != null && this.bTM.getVisibility() == 0) || ((this.bTL != null && this.bTL.getVisibility() == 0) || ((this.bTQ != null && this.bTQ.getVisibility() == 0) || ((this.bTY != null && this.bTY.getVisibility() == 0) || (this.bTT != null && this.bTT.getVisibility() == 0))));
    }

    public void hideAll() {
        afk();
        U(this.bTO);
    }

    public void afk() {
        this.bTP.setVisibility(8);
        hideMore();
        Yo();
        afb();
        afd();
        afi();
        aff();
    }

    public void afl() {
        if (TbadkCoreApplication.m255getInst().isKeyboardHeightCanUsed()) {
            if (this.bTK != null && this.bTK.getVisibility() == 0) {
                afc();
            } else if (this.bTL != null && this.bTL.getVisibility() == 0) {
                afa();
            } else if (this.bTM != null && this.bTM.getVisibility() == 0) {
                Yp();
            } else if (this.bTQ != null && this.bTQ.getVisibility() == 0) {
                afe();
            } else if (this.bTY != null && this.bTY.getVisibility() == 0) {
                afh();
            } else if (this.bTT != null && this.bTT.getVisibility() == 0) {
                afg();
            }
        }
    }

    public void afm() {
        hideAll();
        afc();
    }

    public void afn() {
        hideAll();
        afa();
    }

    public void afo() {
        hideAll();
        Yp();
    }

    public void afp() {
        hideAll();
        afe();
    }

    public void afq() {
        hideAll();
        afh();
    }

    public void afr() {
        hideAll();
        afg();
    }

    public void V(View view) {
        if (!this.bTZ) {
            hideAll();
            this.bTO = view;
            T(view);
        }
    }

    public boolean afs() {
        BaseAdapter adapter;
        return (this.bTS == null || (adapter = this.bTS.getAdapter()) == null || adapter.getCount() <= 0) ? false : true;
    }

    public boolean aft() {
        BaseAdapter adapter;
        return (this.bTV == null || (adapter = this.bTV.getAdapter()) == null || adapter.getCount() <= 0) ? false : true;
    }

    public boolean afu() {
        VoiceData.VoiceModel voiceModel;
        return (this.bTM == null || (voiceModel = this.bTM.getVoiceModel()) == null || voiceModel.getId() == null || voiceModel.getId().length() <= 0) ? false : true;
    }

    public VoiceData.VoiceModel getAudioData() {
        if (this.bTM == null) {
            return null;
        }
        return this.bTM.getVoiceModel();
    }

    public void afv() {
        if (this.bTN != null) {
            this.bTN.afz();
        }
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        if (this.bTM != null && voiceModel != null) {
            this.bTM.c(voiceModel);
        }
    }

    public void Fp() {
        if (this.bTM != null) {
            this.bTM.aia();
        }
    }

    public void clearData() {
        if (this.bTM != null) {
            this.bTM.reset();
            setImage(null);
            this.bTK.vn();
        }
    }

    public void Fq() {
        if (this.bTM != null) {
            this.bTM.onStopingRecorder();
        }
    }

    public void afw() {
        Fq();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        this.XD = new p(this, wVar);
        this.bUa.setPositiveButton(com.baidu.tieba.z.editor_dialog_yes, new q(this));
        this.bTK.setOnClickListener(new r(this));
        this.bTN = new s(this);
        if (this.bTM != null) {
            this.bTM.setCallback(this.bTN);
        }
    }

    public boolean afx() {
        return this.bTZ;
    }

    public void setImage(Bitmap bitmap) {
        if (bitmap == null) {
            this.bTK.setmImagetype(0);
        }
        this.bTK.setImage(bitmap);
    }

    public void aI(boolean z) {
        this.bUc = z;
        this.bTK.aI(z);
        if (this.bTL != null) {
            this.bTL.setShowBigEmotion(!z);
        }
    }

    public void vr() {
        this.bTK.vr();
    }

    public void onChangeSkinType(int i) {
        if (this.bTL != null) {
            this.bTL.onChangeSkinType(i);
        }
        this.bTK.onChangeSkinType(i);
        if (this.bTY != null) {
            this.bTY.onChangeSkinType(i);
        }
        if (this.bTM != null) {
            com.baidu.tbadk.core.util.ax.i(this.bTM, com.baidu.tieba.t.record_voice_container_bg);
        }
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        aeV();
        this.bUf = writeImagesInfo;
        this.bTS.a(new u(this, writeImagesInfo), z);
        int maxItemNum = this.bTS.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (!com.baidu.tieba.tbadkCore.as.agh().agi() && size > 1) {
            this.bTX.setText(com.baidu.tieba.z.editor_mutiiamge_drag_tip);
            com.baidu.tieba.tbadkCore.as.agh().et(true);
        } else {
            this.bTX.setText(getResources().getString(com.baidu.tieba.z.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
        }
        if (size > 0) {
            this.bTK.ee(new StringBuilder(String.valueOf(size)).toString());
        } else {
            this.bTK.vg();
        }
        this.XD.handleAction(13, null);
        aeZ();
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        aeW();
        this.bUg = writeImagesInfo;
        this.bTV.a((BaseAdapter) new u(this, this.bUg), false);
        this.XD.handleAction(51, null);
        if (this.bUg.size() > 0) {
            this.bTK.eg("1");
        } else {
            this.bTK.vn();
        }
        this.XD.handleAction(51, null);
        aeZ();
    }

    private View hF(int i) {
        TbadkCoreApplication.m255getInst().getSkinType();
        ImageView imageView = new ImageView(getContext());
        com.baidu.tbadk.core.util.ax.c(imageView, com.baidu.tieba.v.btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        int dip2px = com.baidu.adp.lib.util.l.dip2px(this.mContext, 3.0f);
        imageView.setPadding(dip2px, com.baidu.adp.lib.util.l.dip2px(this.mContext, 1.0f) + getResources().getDimensionPixelSize(com.baidu.tieba.u.default_gap_20) + dip2px, this.padding + dip2px, dip2px);
        imageView.setOnClickListener(new t(this, i));
        return imageView;
    }

    public void afy() {
        if (this.bTS != null) {
            this.bTS.notifyDataSetChanged();
        }
        if (this.bTV != null) {
            this.bTV.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void aa(int i, int i2) {
        if (i != i2 && this.bUf != null && this.bUf.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.bUf.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void refresh() {
        if (this.bUc) {
            this.bTK.vj();
        } else if (TextUtils.isEmpty(TbadkCoreApplication.m255getInst().getDefaultBubble()) && !this.bUc) {
            this.bTK.vj();
        } else {
            this.bTK.vi();
        }
    }
}
