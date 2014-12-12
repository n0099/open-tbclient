package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class TbEditorToolButtonContainer extends m {
    protected TextView YS;
    protected TextView YU;
    protected TextView YV;
    protected EditorToolButton bVd;
    protected EditorToolButton bVe;
    protected EditorToolButton bVf;
    protected EditorToolButton bVg;
    protected EditorToolButton bVh;
    protected TextView bVi;
    protected Context mContext;

    public TbEditorToolButtonContainer(Context context) {
        super(context);
        this.mContext = context;
        initialize();
    }

    public TbEditorToolButtonContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initialize();
    }

    public TbEditorToolButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initialize();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.bVf != null && this.bVf.getTip() != null) {
            int intrinsicWidth = this.bVf.getDrawable().getIntrinsicWidth();
            int intrinsicHeight = this.bVf.getDrawable().getIntrinsicHeight();
            TextView tip = this.bVf.getTip();
            int right = (this.bVf.getRight() - ((this.bVf.getMeasuredWidth() - intrinsicWidth) / 2)) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 7.0f);
            int measuredHeight = (((this.bVf.getMeasuredHeight() - intrinsicHeight) / 2) + this.bVf.getTop()) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 0.0f);
            tip.layout(right, measuredHeight, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + measuredHeight);
        }
        if (this.bVg != null && this.bVg.getTip() != null) {
            int intrinsicWidth2 = this.bVg.getDrawable().getIntrinsicWidth();
            int intrinsicHeight2 = this.bVg.getDrawable().getIntrinsicHeight();
            TextView tip2 = this.bVg.getTip();
            int right2 = (this.bVg.getRight() - ((this.bVg.getMeasuredWidth() - intrinsicWidth2) / 2)) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 9.0f);
            int measuredHeight2 = (((this.bVg.getMeasuredHeight() - intrinsicHeight2) / 2) + this.bVg.getTop()) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 4.0f);
            tip2.layout(right2, measuredHeight2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + measuredHeight2);
        }
        if (this.bVh != null && this.bVh.getTip() != null) {
            int intrinsicWidth3 = this.bVh.getDrawable().getIntrinsicWidth();
            int intrinsicHeight3 = this.bVh.getDrawable().getIntrinsicHeight();
            int measuredWidth = (this.bVh.getMeasuredWidth() - intrinsicWidth3) / 2;
            int measuredHeight3 = (this.bVh.getMeasuredHeight() - intrinsicHeight3) / 2;
            TextView tip3 = this.bVh.getTip();
            if (TextUtils.isEmpty(tip3.getText())) {
                int right3 = (this.bVh.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 7.0f);
                int top = (measuredHeight3 + this.bVh.getTop()) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 0.0f);
                tip3.layout(right3, top, tip3.getMeasuredWidth() + right3, tip3.getMeasuredHeight() + top);
                return;
            }
            int right4 = (this.bVh.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 7.0f);
            int top2 = (measuredHeight3 + this.bVh.getTop()) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 7.0f);
            tip3.layout(right4, top2, tip3.getMeasuredWidth() + right4, tip3.getMeasuredHeight() + top2);
        }
    }

    protected void initialize() {
        Zy();
        this.bVd = (EditorToolButton) findViewById(com.baidu.tieba.w.select_face);
        this.bVe = (EditorToolButton) findViewById(com.baidu.tieba.w.select_at);
        this.bVf = (EditorToolButton) findViewById(com.baidu.tieba.w.select_privilege);
        this.bVg = (EditorToolButton) findViewById(com.baidu.tieba.w.select_baobao);
        this.bVh = (EditorToolButton) findViewById(com.baidu.tieba.w.select_mediacontent);
    }

    protected void Zy() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.x.write_editor_tool_button_container, this, true);
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            View.OnClickListener a = a(wVar);
            this.bVd.setOnClickListener(a);
            this.bVe.setOnClickListener(a);
            this.bVf.setOnClickListener(a);
            this.bVg.setOnClickListener(a);
            this.bVh.setOnClickListener(a);
        }
    }

    public void aga() {
        aeS();
        this.bVd.aeO();
    }

    public void agb() {
        aeS();
        this.bVf.aeO();
    }

    public void agc() {
        this.bVg.aeP();
    }

    public void agd() {
        aeS();
        this.bVg.aeO();
    }

    public void age() {
        aeS();
        this.bVh.aeO();
    }

    public void agf() {
        this.bVh.aeP();
    }

    public void setFaceFocusable(boolean z) {
        this.bVd.setFocusable(z);
    }

    public void setAtFocusable(boolean z) {
        this.bVe.setFocusable(z);
    }

    public void setPrivilegeFocusable(boolean z) {
        this.bVf.setFocusable(z);
    }

    public void setBaobaoFocusable(boolean z) {
        this.bVg.setFocusable(z);
    }

    public void setFaceEnabled(boolean z) {
        this.bVd.setEnabled(z);
    }

    public void setAtEnabled(boolean z) {
        this.bVe.setEnabled(z);
    }

    public void setBaobaoEnabled(boolean z) {
        this.bVg.setEnabled(z);
    }

    public void setPrivilegeEnable(boolean z) {
        this.bVf.setEnabled(z);
    }

    public void setBaobaoEnable(boolean z) {
        this.bVg.setEnabled(z);
    }

    public void ee(String str) {
        if (this.bVi == null) {
            this.bVi = a(this.bVh, true);
        } else {
            b(this.bVh, true);
        }
        this.bVh.ia(str);
    }

    public void agg() {
        if (this.bVg != null) {
            this.bVg.setVisibility(8);
        }
    }

    public void vg() {
        if (this.bVi != null) {
            b(this.bVh, true);
            this.bVh.tF();
        }
    }

    public void afN() {
        if (this.bVi == null) {
            this.bVi = a(this.bVh, false);
        } else {
            b(this.bVh, false);
        }
        this.bVh.tE();
    }

    public void afO() {
        if (this.bVi != null) {
            b(this.bVh, false);
            this.bVh.tF();
        }
    }

    public void vi() {
        if (this.YU == null) {
            this.YU = a(this.bVf, false);
        }
        this.bVf.tE();
    }

    public void vj() {
        this.bVf.tF();
    }

    public void eg(String str) {
        if (this.YV == null) {
            this.YV = a(this.bVg, true);
        }
        this.bVg.ia(str);
    }

    public void vn() {
        this.bVg.tF();
    }

    public void es(boolean z) {
        if (z) {
            this.bVf.yB();
        } else {
            this.bVf.hide();
        }
    }

    public void changeSkinType(int i) {
        if (this.YS != null) {
            com.baidu.tbadk.core.util.ax.i((View) this.YS, com.baidu.tieba.v.icon_news_head_prompt_one);
        }
        if (this.YU != null) {
            com.baidu.tbadk.core.util.ax.i((View) this.YU, com.baidu.tieba.v.icon_news_down_bar_one);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.w wVar) {
        if (editorToolButton == this.bVd) {
            wVar.handleAction(1, null);
        } else if (editorToolButton == this.bVe) {
            wVar.handleAction(0, null);
        } else if (editorToolButton == this.bVf) {
            wVar.handleAction(43, null);
        } else if (editorToolButton == this.bVg) {
            wVar.handleAction(48, null);
        } else if (editorToolButton == this.bVh) {
            wVar.handleAction(37, null);
        }
        if (editorToolButton.aeN()) {
            if (editorToolButton.isFocused()) {
                aeS();
                if (editorToolButton == this.bVd) {
                    wVar.handleAction(3, null);
                } else if (editorToolButton == this.bVe) {
                    wVar.handleAction(16, null);
                } else if (editorToolButton == this.bVf) {
                    wVar.handleAction(45, null);
                } else if (editorToolButton == this.bVg) {
                    wVar.handleAction(49, null);
                } else if (editorToolButton == this.bVh) {
                    wVar.handleAction(39, null);
                }
            } else if (editorToolButton == this.bVd) {
                wVar.handleAction(2, null);
            } else if (editorToolButton == this.bVe) {
                wVar.handleAction(17, null);
                wVar.handleAction(5, null);
            } else if (editorToolButton == this.bVf) {
                wVar.handleAction(44, null);
            } else if (editorToolButton == this.bVg) {
                wVar.handleAction(50, null);
            } else if (editorToolButton == this.bVh) {
                wVar.handleAction(38, null);
            }
        }
    }

    protected View.OnClickListener a(com.baidu.tbadk.editortool.w wVar) {
        return new ax(this, wVar);
    }

    public void refresh() {
        if (TextUtils.isEmpty(TbadkCoreApplication.m255getInst().getDefaultBubble())) {
            vj();
        } else {
            vi();
        }
    }
}
