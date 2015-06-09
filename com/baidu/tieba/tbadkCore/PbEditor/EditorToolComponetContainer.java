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
import com.baidu.tbadk.core.util.ay;
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
    protected LinearLayout Yv;
    private com.baidu.tbadk.editortool.v ajx;
    private boolean ale;
    protected final af cqA;
    private WriteImagesInfo cqB;
    private WriteImagesInfo cqC;
    private com.baidu.tbadk.img.e cqD;
    protected ToolMoreView cqg;
    protected EmotionTabHost cqh;
    protected com.baidu.tieba.tbadkCore.voice.b cqi;
    protected com.baidu.tieba.tbadkCore.voice.c cqj;
    protected View cqk;
    protected View cql;
    protected DragContainer cqm;
    protected DragLayer cqn;
    protected DragHorizonScrollView cqo;
    protected DragContainer cqp;
    protected DragLayer cqq;
    protected DragHorizonScrollView cqr;
    protected TextView cqs;
    protected TextView cqt;
    protected o cqu;
    protected boolean cqv;
    private final boolean cqw;
    private boolean cqx;
    private boolean cqy;
    private int cqz;
    protected Context mContext;
    private int padding;

    public EditorToolComponetContainer(Context context) {
        super(context);
        this.cqv = false;
        this.cqw = true;
        this.ale = false;
        this.cqy = true;
        this.cqA = new af();
        this.mContext = context;
        initialize();
    }

    public EditorToolComponetContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cqv = false;
        this.cqw = true;
        this.ale = false;
        this.cqy = true;
        this.cqA = new af();
        this.mContext = context;
        initialize();
    }

    protected void initialize() {
        com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.editor_tool_container, this, true);
        this.Yv = (LinearLayout) findViewById(com.baidu.tieba.q.tools_container);
        this.cqg = (ToolMoreView) findViewById(com.baidu.tieba.q.tool_view);
        this.cql = findViewById(com.baidu.tieba.q.pb_foot_down_shadow);
        if (a.amX() && this.cqg.getBaobao() != null && this.cqg.getBaobao().isShown()) {
            this.cqg.eE("N");
        }
    }

    private void ang() {
        if (this.cqi == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001279, com.baidu.tieba.tbadkCore.voice.b.class, this.mContext);
            if (runTask != null && runTask.getData() != null) {
                this.cqi = (com.baidu.tieba.tbadkCore.voice.b) runTask.getData();
            }
            if (this.cqi != null) {
                this.Yv.addView(this.cqi, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.pb_editor_faceview_height)));
                this.cqi.setVisibility(8);
                ay.i(this.cqi, com.baidu.tieba.n.record_voice_container_bg);
                if (this.cqj != null) {
                    this.cqi.setCallback(this.cqj);
                }
                if (this.ajx != null) {
                    this.ajx.handleAction(54, null);
                }
            }
        }
    }

    private void anh() {
        if (this.cqh == null) {
            this.cqh = new EmotionTabHost(this.mContext);
            this.Yv.addView(this.cqh, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.pb_editor_faceview_height)));
            this.cqh.setVisibility(8);
            this.cqh.setShowBigEmotion(!this.cqx);
            this.cqh.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
            this.cqh.setOnDataSelected(new d(this));
        }
    }

    private void ani() {
        if (this.cqm == null) {
            com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.editor_tool_container_image, this.Yv);
            this.cqm = (DragContainer) findViewById(com.baidu.tieba.q.muti_image_upload);
            this.cqn = (DragLayer) findViewById(com.baidu.tieba.q.muti_image_upload_draglayer);
            this.cqo = (DragHorizonScrollView) findViewById(com.baidu.tieba.q.muti_image_upload_dragscrollview);
            com.baidu.tieba.tbadkCore.imgView.a aVar = new com.baidu.tieba.tbadkCore.imgView.a(getContext());
            aVar.a(this.cqn);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.g) this.cqo);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.f) this.cqo);
            this.cqt = (TextView) findViewById(com.baidu.tieba.q.muti_image_tips);
            this.cqz = getResources().getDimensionPixelSize(com.baidu.tieba.o.editor_muti_image_upload_scrollview_paddingleft);
            this.padding = getResources().getDimensionPixelSize(com.baidu.tieba.o.default_gap_24);
            this.cqo.setAddView(iL(7));
            this.cqo.setOnSwapDataListener(this);
            this.cqo.setMaxItemNum(10);
            if (this.cqD == null) {
                this.cqD = new com.baidu.tbadk.img.e(this.mContext);
            }
            ay.b(this.cqt, com.baidu.tieba.n.cp_cont_c, 1);
        }
    }

    private void anj() {
        if (this.cqp == null) {
            com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.editor_tool_container_baobao, this.Yv);
            this.cqp = (DragContainer) findViewById(com.baidu.tieba.q.baobao_image_upload);
            this.cqq = (DragLayer) findViewById(com.baidu.tieba.q.baobao_image_upload_draglayer);
            this.cqr = (DragHorizonScrollView) findViewById(com.baidu.tieba.q.baobao_image_upload_dragscrollview);
            this.cqs = (TextView) findViewById(com.baidu.tieba.q.baobao_image_tips);
            com.baidu.tieba.tbadkCore.imgView.a aVar = new com.baidu.tieba.tbadkCore.imgView.a(getContext());
            aVar.a(this.cqq);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.g) this.cqr);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.f) this.cqr);
            this.cqr.setAddView(iL(48));
            this.cqr.setOnSwapDataListener(this);
            this.cqr.setMaxItemNum(1);
            this.cqr.setCenterStart(true);
            if (this.cqD == null) {
                this.cqD = new com.baidu.tbadk.img.e(this.mContext);
            }
        }
    }

    private void ank() {
        if (this.cqu == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001289, o.class, this.mContext);
            if (runTask != null && runTask.getData() != null) {
                this.cqu = (o) runTask.getData();
            }
            if (this.cqu != null) {
                this.Yv.addView(this.cqu, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.pb_editor_faceview_height)));
                this.cqu.setVisibility(8);
                this.cqu.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
                this.cqu.setOnDataSelected(new e(this));
            }
        }
    }

    protected void anl() {
        com.baidu.adp.base.m B = com.baidu.adp.base.n.B(this.mContext);
        if (B != null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2010041, this.cqA);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2010041, B.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessageToUI(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anm() {
        if (anI()) {
            this.cqA.crp = 1;
        } else {
            this.cqA.crp = 0;
        }
        if (this.cqB != null && this.cqB.getChosedFiles() != null && this.cqB.getChosedFiles().size() > 0) {
            this.cqA.cro = this.cqB.getChosedFiles().size();
        } else {
            this.cqA.cro = 0;
        }
        if (this.cqC != null && this.cqC.getChosedFiles() != null && this.cqC.getChosedFiles().size() > 0) {
            this.cqA.crq = this.cqC.getChosedFiles().size();
        } else {
            this.cqA.crq = 0;
        }
        anl();
    }

    public void setHideBaobao(boolean z) {
        this.ale = z;
        if (this.cqg != null) {
            this.cqg.setHideBaobao(z);
            if (z && a.amX()) {
                this.cqg.zQ();
            }
        }
    }

    public void setShadowBackground(int i) {
        if (this.cql != null) {
            ay.j(this.cql, i);
        }
    }

    public void setShadowHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (i > 0 && (layoutParams = this.cql.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.cql.setLayoutParams(layoutParams);
        }
    }

    public void setFrom(int i) {
        if (this.cqh != null) {
            this.cqh.setFrom(i);
        }
    }

    protected void ann() {
        anh();
        this.cql.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().getKeyboardHeight() > 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqh.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.cqh.setLayoutParams(layoutParams);
        }
        this.cqh.setVisibility(0);
    }

    protected void ano() {
        if (this.cqh != null) {
            this.cqh.setVisibility(8);
        }
    }

    public void anp() {
        if (this.cqg != null) {
            this.cqg.zR();
        }
    }

    public void aca() {
        if (this.cqg != null) {
            this.cqg.zS();
        }
    }

    protected void acm() {
        ang();
        if (this.cqi != null) {
            this.cql.setVisibility(0);
            if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqi.getLayoutParams();
                layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
                this.cqi.setLayoutParams(layoutParams);
            }
            this.cqi.setVisibility(0);
        }
    }

    protected void acl() {
        if (this.cqi != null) {
            this.cqi.setVisibility(8);
        }
    }

    protected void anq() {
        this.cql.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqg.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.cqg.setLayoutParams(layoutParams);
        }
        this.cqg.setVisibility(0);
    }

    public void anr() {
        if (this.cqm != null) {
            this.cqm.setVisibility(8);
        }
    }

    public void ans() {
        ani();
        this.cql.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqm.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.cqm.setLayoutParams(layoutParams);
        }
        this.cqm.setVisibility(0);
    }

    public void ant() {
        if (this.cqp != null) {
            this.cqp.setVisibility(8);
        }
    }

    public void zQ() {
        this.cqg.zQ();
    }

    public void eC(String str) {
        if (this.cqg != null) {
            this.cqg.eC(str);
        }
    }

    public void zJ() {
        if (this.cqg != null) {
            this.cqg.zJ();
        }
    }

    public void zR() {
        if (this.cqg != null) {
            this.cqg.zR();
        }
    }

    public void zS() {
        if (this.cqg != null) {
            this.cqg.zS();
        }
    }

    public boolean zN() {
        if (this.cqg == null) {
            return false;
        }
        return this.cqg.zN();
    }

    public void zO() {
        if (this.cqg != null) {
            this.cqg.zO();
        }
    }

    public void zP() {
        if (this.cqg != null) {
            this.cqg.zP();
        }
    }

    public void anu() {
        anj();
        this.cql.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqp.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.cqp.setLayoutParams(layoutParams);
        }
        this.cqp.setVisibility(0);
        if (TextUtils.isEmpty(this.cqs.getText())) {
            this.cqs.setText(com.baidu.tieba.t.baobao_remind);
        }
    }

    protected void hideMore() {
        this.cqg.setVisibility(8);
    }

    protected void anv() {
        ank();
        this.cql.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqu.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.cqu.setLayoutParams(layoutParams);
        }
        this.cqu.setVisibility(0);
    }

    protected void anw() {
        if (this.cqu != null) {
            this.cqu.setVisibility(8);
        }
    }

    public void Z(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.n.d(this.mContext, view);
            this.cqv = true;
        }
    }

    public void aa(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.n.c(this.mContext, view);
            this.cqv = false;
        }
    }

    public boolean anx() {
        return this.cqg.getVisibility() == 0 || (this.cqi != null && this.cqi.getVisibility() == 0) || ((this.cqh != null && this.cqh.getVisibility() == 0) || ((this.cqm != null && this.cqm.getVisibility() == 0) || ((this.cqu != null && this.cqu.getVisibility() == 0) || (this.cqp != null && this.cqp.getVisibility() == 0))));
    }

    public void hideAll() {
        any();
        aa(this.cqk);
    }

    public void any() {
        this.cql.setVisibility(8);
        hideMore();
        acl();
        ano();
        anr();
        anw();
        ant();
    }

    public void anz() {
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            if (this.cqg != null && this.cqg.getVisibility() == 0) {
                anq();
            } else if (this.cqh != null && this.cqh.getVisibility() == 0) {
                ann();
            } else if (this.cqi != null && this.cqi.getVisibility() == 0) {
                acm();
            } else if (this.cqm != null && this.cqm.getVisibility() == 0) {
                ans();
            } else if (this.cqu != null && this.cqu.getVisibility() == 0) {
                anv();
            } else if (this.cqp != null && this.cqp.getVisibility() == 0) {
                anu();
            }
        }
    }

    public boolean acF() {
        return this.cqy;
    }

    public void setAudioCanUse(boolean z) {
        this.cqy = z;
    }

    public void anA() {
        hideAll();
        anq();
    }

    public void anB() {
        hideAll();
        ann();
    }

    public void anC() {
        if (acF()) {
            hideAll();
            acm();
        }
    }

    public void anD() {
        hideAll();
        ans();
    }

    public void anE() {
        hideAll();
        anv();
    }

    public void anF() {
        hideAll();
        anu();
    }

    public void ab(View view) {
        if (!this.cqv) {
            hideAll();
            this.cqk = view;
            Z(view);
        }
    }

    public boolean anG() {
        BaseAdapter adapter;
        return (this.cqo == null || (adapter = this.cqo.getAdapter()) == null || adapter.getCount() <= 0) ? false : true;
    }

    public boolean anH() {
        BaseAdapter adapter;
        return (this.cqr == null || (adapter = this.cqr.getAdapter()) == null || adapter.getCount() <= 0) ? false : true;
    }

    public boolean anI() {
        VoiceData.VoiceModel voiceModel;
        return (this.cqi == null || (voiceModel = this.cqi.getVoiceModel()) == null || voiceModel.getId() == null || voiceModel.getId().length() <= 0) ? false : true;
    }

    public VoiceData.VoiceModel getAudioData() {
        if (this.cqi == null) {
            return null;
        }
        return this.cqi.getVoiceModel();
    }

    public void anJ() {
        if (this.cqj != null) {
            this.cqj.anN();
        }
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        if (this.cqi != null && voiceModel != null) {
            this.cqi.a(voiceModel);
        }
    }

    public void Kr() {
        if (this.cqi != null) {
            this.cqi.ov();
        }
    }

    public void clearData() {
        if (this.cqi != null) {
            this.cqi.reset();
            setImage(null);
            this.cqg.zQ();
        }
    }

    public void Ks() {
        if (this.cqi != null) {
            this.cqi.onStopingRecorder();
        }
    }

    public void anK() {
        Ks();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        this.ajx = new f(this, vVar);
        this.cqg.setOnClickListener(new g(this));
        this.cqj = new h(this);
        if (this.cqi != null) {
            this.cqi.setCallback(this.cqj);
        }
    }

    public boolean anL() {
        return this.cqv;
    }

    public void setImage(Bitmap bitmap) {
        if (bitmap == null) {
            this.cqg.setmImagetype(0);
        }
        this.cqg.setImage(bitmap);
    }

    public void aX(boolean z) {
        this.cqx = z;
        this.cqg.aX(z);
        if (this.cqh != null) {
            this.cqh.setShowBigEmotion(!z);
        }
    }

    public void zV() {
        this.cqg.zV();
    }

    public void zU() {
        this.cqg.zU();
    }

    public void zW() {
        this.cqg.zW();
    }

    public void onChangeSkinType(int i) {
        if (this.cqh != null) {
            this.cqh.onChangeSkinType(i);
        }
        this.cqg.onChangeSkinType(i);
        if (this.cqu != null) {
            this.cqu.onChangeSkinType(i);
        }
        if (this.cqi != null) {
            ay.i(this.cqi, com.baidu.tieba.n.record_voice_container_bg);
        }
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        ani();
        this.cqB = writeImagesInfo;
        this.cqo.a(new j(this, writeImagesInfo), z);
        int maxItemNum = this.cqo.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (!av.aog().aoh() && size > 1) {
            this.cqt.setText(com.baidu.tieba.t.editor_mutiiamge_drag_tip);
            av.aog().ff(true);
        } else {
            this.cqt.setText(getResources().getString(com.baidu.tieba.t.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
        }
        if (size > 0) {
            this.cqg.eC(new StringBuilder(String.valueOf(size)).toString());
        } else {
            this.cqg.zJ();
        }
        this.ajx.handleAction(13, null);
        anm();
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        anj();
        this.cqC = writeImagesInfo;
        this.cqr.a((BaseAdapter) new j(this, this.cqC), false);
        this.ajx.handleAction(51, null);
        if (this.cqC.size() > 0) {
            this.cqg.eE("1");
        } else {
            this.cqg.zQ();
        }
        this.ajx.handleAction(51, null);
        anm();
    }

    private View iL(int i) {
        TbadkCoreApplication.m411getInst().getSkinType();
        ImageView imageView = new ImageView(getContext());
        ay.c(imageView, com.baidu.tieba.p.btn_add_photo_selector);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setClickable(true);
        int dip2px = com.baidu.adp.lib.util.n.dip2px(this.mContext, 3.0f);
        imageView.setPadding(dip2px, com.baidu.adp.lib.util.n.dip2px(this.mContext, 1.0f) + getResources().getDimensionPixelSize(com.baidu.tieba.o.default_gap_20) + dip2px, this.padding + dip2px, dip2px);
        imageView.setOnClickListener(new i(this, i));
        return imageView;
    }

    public void anM() {
        if (this.cqo != null) {
            this.cqo.notifyDataSetChanged();
        }
        if (this.cqr != null) {
            this.cqr.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void ag(int i, int i2) {
        if (i != i2 && this.cqB != null && this.cqB.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.cqB.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void refresh() {
        if (this.cqx) {
            this.cqg.zM();
        } else if (TextUtils.isEmpty(TbadkCoreApplication.m411getInst().getDefaultBubble()) && !this.cqx) {
            this.cqg.zM();
        } else {
            this.cqg.zL();
        }
    }
}
