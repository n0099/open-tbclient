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
    private WriteImagesInfo cqA;
    private WriteImagesInfo cqB;
    private com.baidu.tbadk.img.e cqC;
    protected ToolMoreView cqf;
    protected EmotionTabHost cqg;
    protected com.baidu.tieba.tbadkCore.voice.b cqh;
    protected com.baidu.tieba.tbadkCore.voice.c cqi;
    protected View cqj;
    protected View cqk;
    protected DragContainer cql;
    protected DragLayer cqm;
    protected DragHorizonScrollView cqn;
    protected DragContainer cqo;
    protected DragLayer cqp;
    protected DragHorizonScrollView cqq;
    protected TextView cqr;
    protected TextView cqs;
    protected o cqt;
    protected boolean cqu;
    private final boolean cqv;
    private boolean cqw;
    private boolean cqx;
    private int cqy;
    protected final af cqz;
    protected Context mContext;
    private int padding;

    public EditorToolComponetContainer(Context context) {
        super(context);
        this.cqu = false;
        this.cqv = true;
        this.ale = false;
        this.cqx = true;
        this.cqz = new af();
        this.mContext = context;
        initialize();
    }

    public EditorToolComponetContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cqu = false;
        this.cqv = true;
        this.ale = false;
        this.cqx = true;
        this.cqz = new af();
        this.mContext = context;
        initialize();
    }

    protected void initialize() {
        com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.editor_tool_container, this, true);
        this.Yv = (LinearLayout) findViewById(com.baidu.tieba.q.tools_container);
        this.cqf = (ToolMoreView) findViewById(com.baidu.tieba.q.tool_view);
        this.cqk = findViewById(com.baidu.tieba.q.pb_foot_down_shadow);
        if (a.amW() && this.cqf.getBaobao() != null && this.cqf.getBaobao().isShown()) {
            this.cqf.eE("N");
        }
    }

    private void anf() {
        if (this.cqh == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001279, com.baidu.tieba.tbadkCore.voice.b.class, this.mContext);
            if (runTask != null && runTask.getData() != null) {
                this.cqh = (com.baidu.tieba.tbadkCore.voice.b) runTask.getData();
            }
            if (this.cqh != null) {
                this.Yv.addView(this.cqh, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.pb_editor_faceview_height)));
                this.cqh.setVisibility(8);
                ay.i(this.cqh, com.baidu.tieba.n.record_voice_container_bg);
                if (this.cqi != null) {
                    this.cqh.setCallback(this.cqi);
                }
                if (this.ajx != null) {
                    this.ajx.handleAction(54, null);
                }
            }
        }
    }

    private void ang() {
        if (this.cqg == null) {
            this.cqg = new EmotionTabHost(this.mContext);
            this.Yv.addView(this.cqg, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.pb_editor_faceview_height)));
            this.cqg.setVisibility(8);
            this.cqg.setShowBigEmotion(!this.cqw);
            this.cqg.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
            this.cqg.setOnDataSelected(new d(this));
        }
    }

    private void anh() {
        if (this.cql == null) {
            com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.editor_tool_container_image, this.Yv);
            this.cql = (DragContainer) findViewById(com.baidu.tieba.q.muti_image_upload);
            this.cqm = (DragLayer) findViewById(com.baidu.tieba.q.muti_image_upload_draglayer);
            this.cqn = (DragHorizonScrollView) findViewById(com.baidu.tieba.q.muti_image_upload_dragscrollview);
            com.baidu.tieba.tbadkCore.imgView.a aVar = new com.baidu.tieba.tbadkCore.imgView.a(getContext());
            aVar.a(this.cqm);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.g) this.cqn);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.f) this.cqn);
            this.cqs = (TextView) findViewById(com.baidu.tieba.q.muti_image_tips);
            this.cqy = getResources().getDimensionPixelSize(com.baidu.tieba.o.editor_muti_image_upload_scrollview_paddingleft);
            this.padding = getResources().getDimensionPixelSize(com.baidu.tieba.o.default_gap_24);
            this.cqn.setAddView(iL(7));
            this.cqn.setOnSwapDataListener(this);
            this.cqn.setMaxItemNum(10);
            if (this.cqC == null) {
                this.cqC = new com.baidu.tbadk.img.e(this.mContext);
            }
            ay.b(this.cqs, com.baidu.tieba.n.cp_cont_c, 1);
        }
    }

    private void ani() {
        if (this.cqo == null) {
            com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.editor_tool_container_baobao, this.Yv);
            this.cqo = (DragContainer) findViewById(com.baidu.tieba.q.baobao_image_upload);
            this.cqp = (DragLayer) findViewById(com.baidu.tieba.q.baobao_image_upload_draglayer);
            this.cqq = (DragHorizonScrollView) findViewById(com.baidu.tieba.q.baobao_image_upload_dragscrollview);
            this.cqr = (TextView) findViewById(com.baidu.tieba.q.baobao_image_tips);
            com.baidu.tieba.tbadkCore.imgView.a aVar = new com.baidu.tieba.tbadkCore.imgView.a(getContext());
            aVar.a(this.cqp);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.g) this.cqq);
            aVar.a((com.baidu.tieba.tbadkCore.imgView.f) this.cqq);
            this.cqq.setAddView(iL(48));
            this.cqq.setOnSwapDataListener(this);
            this.cqq.setMaxItemNum(1);
            this.cqq.setCenterStart(true);
            if (this.cqC == null) {
                this.cqC = new com.baidu.tbadk.img.e(this.mContext);
            }
        }
    }

    private void anj() {
        if (this.cqt == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001289, o.class, this.mContext);
            if (runTask != null && runTask.getData() != null) {
                this.cqt = (o) runTask.getData();
            }
            if (this.cqt != null) {
                this.Yv.addView(this.cqt, new LinearLayout.LayoutParams(-1, (int) this.mContext.getResources().getDimension(com.baidu.tieba.o.pb_editor_faceview_height)));
                this.cqt.setVisibility(8);
                this.cqt.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
                this.cqt.setOnDataSelected(new e(this));
            }
        }
    }

    protected void ank() {
        com.baidu.adp.base.m B = com.baidu.adp.base.n.B(this.mContext);
        if (B != null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2010041, this.cqz);
            customResponsedMessage.setOrginalMessage(new CustomMessage(2010041, B.getUniqueId()));
            MessageManager.getInstance().dispatchResponsedMessageToUI(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anl() {
        if (anH()) {
            this.cqz.cro = 1;
        } else {
            this.cqz.cro = 0;
        }
        if (this.cqA != null && this.cqA.getChosedFiles() != null && this.cqA.getChosedFiles().size() > 0) {
            this.cqz.crn = this.cqA.getChosedFiles().size();
        } else {
            this.cqz.crn = 0;
        }
        if (this.cqB != null && this.cqB.getChosedFiles() != null && this.cqB.getChosedFiles().size() > 0) {
            this.cqz.crp = this.cqB.getChosedFiles().size();
        } else {
            this.cqz.crp = 0;
        }
        ank();
    }

    public void setHideBaobao(boolean z) {
        this.ale = z;
        if (this.cqf != null) {
            this.cqf.setHideBaobao(z);
            if (z && a.amW()) {
                this.cqf.zP();
            }
        }
    }

    public void setShadowBackground(int i) {
        if (this.cqk != null) {
            ay.j(this.cqk, i);
        }
    }

    public void setShadowHeight(int i) {
        ViewGroup.LayoutParams layoutParams;
        if (i > 0 && (layoutParams = this.cqk.getLayoutParams()) != null) {
            layoutParams.height = i;
            this.cqk.setLayoutParams(layoutParams);
        }
    }

    public void setFrom(int i) {
        if (this.cqg != null) {
            this.cqg.setFrom(i);
        }
    }

    protected void anm() {
        ang();
        this.cqk.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().getKeyboardHeight() > 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqg.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.cqg.setLayoutParams(layoutParams);
        }
        this.cqg.setVisibility(0);
    }

    protected void ann() {
        if (this.cqg != null) {
            this.cqg.setVisibility(8);
        }
    }

    public void ano() {
        if (this.cqf != null) {
            this.cqf.zQ();
        }
    }

    public void abZ() {
        if (this.cqf != null) {
            this.cqf.zR();
        }
    }

    protected void acl() {
        anf();
        if (this.cqh != null) {
            this.cqk.setVisibility(0);
            if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqh.getLayoutParams();
                layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
                this.cqh.setLayoutParams(layoutParams);
            }
            this.cqh.setVisibility(0);
        }
    }

    protected void ack() {
        if (this.cqh != null) {
            this.cqh.setVisibility(8);
        }
    }

    protected void anp() {
        this.cqk.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqf.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.cqf.setLayoutParams(layoutParams);
        }
        this.cqf.setVisibility(0);
    }

    public void anq() {
        if (this.cql != null) {
            this.cql.setVisibility(8);
        }
    }

    public void anr() {
        anh();
        this.cqk.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cql.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.cql.setLayoutParams(layoutParams);
        }
        this.cql.setVisibility(0);
    }

    public void ans() {
        if (this.cqo != null) {
            this.cqo.setVisibility(8);
        }
    }

    public void zP() {
        this.cqf.zP();
    }

    public void eC(String str) {
        if (this.cqf != null) {
            this.cqf.eC(str);
        }
    }

    public void zI() {
        if (this.cqf != null) {
            this.cqf.zI();
        }
    }

    public void zQ() {
        if (this.cqf != null) {
            this.cqf.zQ();
        }
    }

    public void zR() {
        if (this.cqf != null) {
            this.cqf.zR();
        }
    }

    public boolean zM() {
        if (this.cqf == null) {
            return false;
        }
        return this.cqf.zM();
    }

    public void zN() {
        if (this.cqf != null) {
            this.cqf.zN();
        }
    }

    public void zO() {
        if (this.cqf != null) {
            this.cqf.zO();
        }
    }

    public void ant() {
        ani();
        this.cqk.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqo.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.cqo.setLayoutParams(layoutParams);
        }
        this.cqo.setVisibility(0);
        if (TextUtils.isEmpty(this.cqr.getText())) {
            this.cqr.setText(com.baidu.tieba.t.baobao_remind);
        }
    }

    protected void hideMore() {
        this.cqf.setVisibility(8);
    }

    protected void anu() {
        anj();
        this.cqk.setVisibility(0);
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cqt.getLayoutParams();
            layoutParams.height = TbadkCoreApplication.m411getInst().getKeyboardHeight();
            this.cqt.setLayoutParams(layoutParams);
        }
        this.cqt.setVisibility(0);
    }

    protected void anv() {
        if (this.cqt != null) {
            this.cqt.setVisibility(8);
        }
    }

    public void Z(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.n.d(this.mContext, view);
            this.cqu = true;
        }
    }

    public void aa(View view) {
        if (view != null) {
            com.baidu.adp.lib.util.n.c(this.mContext, view);
            this.cqu = false;
        }
    }

    public boolean anw() {
        return this.cqf.getVisibility() == 0 || (this.cqh != null && this.cqh.getVisibility() == 0) || ((this.cqg != null && this.cqg.getVisibility() == 0) || ((this.cql != null && this.cql.getVisibility() == 0) || ((this.cqt != null && this.cqt.getVisibility() == 0) || (this.cqo != null && this.cqo.getVisibility() == 0))));
    }

    public void hideAll() {
        anx();
        aa(this.cqj);
    }

    public void anx() {
        this.cqk.setVisibility(8);
        hideMore();
        ack();
        ann();
        anq();
        anv();
        ans();
    }

    public void any() {
        if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanUsed()) {
            if (this.cqf != null && this.cqf.getVisibility() == 0) {
                anp();
            } else if (this.cqg != null && this.cqg.getVisibility() == 0) {
                anm();
            } else if (this.cqh != null && this.cqh.getVisibility() == 0) {
                acl();
            } else if (this.cql != null && this.cql.getVisibility() == 0) {
                anr();
            } else if (this.cqt != null && this.cqt.getVisibility() == 0) {
                anu();
            } else if (this.cqo != null && this.cqo.getVisibility() == 0) {
                ant();
            }
        }
    }

    public boolean acE() {
        return this.cqx;
    }

    public void setAudioCanUse(boolean z) {
        this.cqx = z;
    }

    public void anz() {
        hideAll();
        anp();
    }

    public void anA() {
        hideAll();
        anm();
    }

    public void anB() {
        if (acE()) {
            hideAll();
            acl();
        }
    }

    public void anC() {
        hideAll();
        anr();
    }

    public void anD() {
        hideAll();
        anu();
    }

    public void anE() {
        hideAll();
        ant();
    }

    public void ab(View view) {
        if (!this.cqu) {
            hideAll();
            this.cqj = view;
            Z(view);
        }
    }

    public boolean anF() {
        BaseAdapter adapter;
        return (this.cqn == null || (adapter = this.cqn.getAdapter()) == null || adapter.getCount() <= 0) ? false : true;
    }

    public boolean anG() {
        BaseAdapter adapter;
        return (this.cqq == null || (adapter = this.cqq.getAdapter()) == null || adapter.getCount() <= 0) ? false : true;
    }

    public boolean anH() {
        VoiceData.VoiceModel voiceModel;
        return (this.cqh == null || (voiceModel = this.cqh.getVoiceModel()) == null || voiceModel.getId() == null || voiceModel.getId().length() <= 0) ? false : true;
    }

    public VoiceData.VoiceModel getAudioData() {
        if (this.cqh == null) {
            return null;
        }
        return this.cqh.getVoiceModel();
    }

    public void anI() {
        if (this.cqi != null) {
            this.cqi.anM();
        }
    }

    public void setAudioData(VoiceData.VoiceModel voiceModel) {
        if (this.cqh != null && voiceModel != null) {
            this.cqh.a(voiceModel);
        }
    }

    public void Kq() {
        if (this.cqh != null) {
            this.cqh.ov();
        }
    }

    public void clearData() {
        if (this.cqh != null) {
            this.cqh.reset();
            setImage(null);
            this.cqf.zP();
        }
    }

    public void Kr() {
        if (this.cqh != null) {
            this.cqh.onStopingRecorder();
        }
    }

    public void anJ() {
        Kr();
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        this.ajx = new f(this, vVar);
        this.cqf.setOnClickListener(new g(this));
        this.cqi = new h(this);
        if (this.cqh != null) {
            this.cqh.setCallback(this.cqi);
        }
    }

    public boolean anK() {
        return this.cqu;
    }

    public void setImage(Bitmap bitmap) {
        if (bitmap == null) {
            this.cqf.setmImagetype(0);
        }
        this.cqf.setImage(bitmap);
    }

    public void aX(boolean z) {
        this.cqw = z;
        this.cqf.aX(z);
        if (this.cqg != null) {
            this.cqg.setShowBigEmotion(!z);
        }
    }

    public void zU() {
        this.cqf.zU();
    }

    public void zT() {
        this.cqf.zT();
    }

    public void zV() {
        this.cqf.zV();
    }

    public void onChangeSkinType(int i) {
        if (this.cqg != null) {
            this.cqg.onChangeSkinType(i);
        }
        this.cqf.onChangeSkinType(i);
        if (this.cqt != null) {
            this.cqt.onChangeSkinType(i);
        }
        if (this.cqh != null) {
            ay.i(this.cqh, com.baidu.tieba.n.record_voice_container_bg);
        }
    }

    public void a(WriteImagesInfo writeImagesInfo, boolean z) {
        anh();
        this.cqA = writeImagesInfo;
        this.cqn.a(new j(this, writeImagesInfo), z);
        int maxItemNum = this.cqn.getMaxItemNum();
        int size = writeImagesInfo.size();
        if (!av.aof().aog() && size > 1) {
            this.cqs.setText(com.baidu.tieba.t.editor_mutiiamge_drag_tip);
            av.aof().ff(true);
        } else {
            this.cqs.setText(getResources().getString(com.baidu.tieba.t.editor_mutiiamge_text, Integer.valueOf(size), Integer.valueOf(maxItemNum - size)));
        }
        if (size > 0) {
            this.cqf.eC(new StringBuilder(String.valueOf(size)).toString());
        } else {
            this.cqf.zI();
        }
        this.ajx.handleAction(13, null);
        anl();
    }

    public void setBaobaoUris(WriteImagesInfo writeImagesInfo) {
        ani();
        this.cqB = writeImagesInfo;
        this.cqq.a((BaseAdapter) new j(this, this.cqB), false);
        this.ajx.handleAction(51, null);
        if (this.cqB.size() > 0) {
            this.cqf.eE("1");
        } else {
            this.cqf.zP();
        }
        this.ajx.handleAction(51, null);
        anl();
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

    public void anL() {
        if (this.cqn != null) {
            this.cqn.notifyDataSetChanged();
        }
        if (this.cqq != null) {
            this.cqq.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void ag(int i, int i2) {
        if (i != i2 && this.cqA != null && this.cqA.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = this.cqA.getChosedFiles();
            chosedFiles.add(i2, chosedFiles.remove(i));
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void refresh() {
        if (this.cqw) {
            this.cqf.zL();
        } else if (TextUtils.isEmpty(TbadkCoreApplication.m411getInst().getDefaultBubble()) && !this.cqw) {
            this.cqf.zL();
        } else {
            this.cqf.zK();
        }
    }
}
