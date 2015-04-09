package com.baidu.tieba.write.editor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolButton;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class TbEditorToolButtonContainer extends com.baidu.tieba.tbadkCore.PbEditor.c {
    protected TextView ajX;
    protected TextView ajZ;
    protected EditorToolButton cna;
    protected TextView cnc;
    protected EditorToolButton cvj;
    protected EditorToolButton cvk;
    protected EditorToolButton cvl;
    protected EditorToolButton cvm;
    protected TextView cvn;
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
        if (this.cna != null && this.cna.getTip() != null) {
            int intrinsicWidth = this.cna.getDrawable().getIntrinsicWidth();
            int intrinsicHeight = this.cna.getDrawable().getIntrinsicHeight();
            TextView tip = this.cna.getTip();
            int right = (this.cna.getRight() - ((this.cna.getMeasuredWidth() - intrinsicWidth) / 2)) - n.dip2px(this.mContext, 9.0f);
            int measuredHeight = (((this.cna.getMeasuredHeight() - intrinsicHeight) / 2) + this.cna.getTop()) - n.dip2px(this.mContext, 4.0f);
            tip.layout(right, measuredHeight, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + measuredHeight);
        }
        if (this.cvl != null && this.cvl.getTip() != null) {
            int intrinsicWidth2 = this.cvl.getDrawable().getIntrinsicWidth();
            int intrinsicHeight2 = this.cvl.getDrawable().getIntrinsicHeight();
            TextView tip2 = this.cvl.getTip();
            int right2 = (this.cvl.getRight() - ((this.cvl.getMeasuredWidth() - intrinsicWidth2) / 2)) - n.dip2px(this.mContext, 9.0f);
            int measuredHeight2 = (((this.cvl.getMeasuredHeight() - intrinsicHeight2) / 2) + this.cvl.getTop()) - n.dip2px(this.mContext, 4.0f);
            tip2.layout(right2, measuredHeight2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + measuredHeight2);
        }
        if (this.cvk != null && this.cvk.getTip() != null) {
            int intrinsicWidth3 = this.cvk.getDrawable().getIntrinsicWidth();
            int intrinsicHeight3 = this.cvk.getDrawable().getIntrinsicHeight();
            int measuredWidth = (this.cvk.getMeasuredWidth() - intrinsicWidth3) / 2;
            int measuredHeight3 = (this.cvk.getMeasuredHeight() - intrinsicHeight3) / 2;
            TextView tip3 = this.cvk.getTip();
            if (TextUtils.isEmpty(tip3.getText())) {
                int right3 = (this.cvk.getRight() - measuredWidth) - n.dip2px(this.mContext, 7.0f);
                int top = (measuredHeight3 + this.cvk.getTop()) - n.dip2px(this.mContext, 0.0f);
                tip3.layout(right3, top, tip3.getMeasuredWidth() + right3, tip3.getMeasuredHeight() + top);
                return;
            }
            int right4 = (this.cvk.getRight() - measuredWidth) - n.dip2px(this.mContext, 7.0f);
            int top2 = (measuredHeight3 + this.cvk.getTop()) - n.dip2px(this.mContext, 7.0f);
            tip3.layout(right4, top2, tip3.getMeasuredWidth() + right4, tip3.getMeasuredHeight() + top2);
        }
    }

    protected void initialize() {
        acx();
        this.cvj = (EditorToolButton) findViewById(v.select_face);
        this.cvm = (EditorToolButton) findViewById(v.select_at);
        this.cvl = (EditorToolButton) findViewById(v.select_privilege);
        this.cvk = (EditorToolButton) findViewById(v.select_picture);
        this.cna = (EditorToolButton) findViewById(v.select_more);
        this.cna.hideTip();
        setDrawTop(false);
    }

    protected void acx() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, w.write_editor_tool_button_container, this, true);
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        if (vVar != null) {
            View.OnClickListener b = b(vVar);
            this.cvj.setOnClickListener(b);
            this.cvm.setOnClickListener(b);
            this.cvk.setOnClickListener(b);
            this.cvl.setOnClickListener(b);
            this.cna.setOnClickListener(b);
        }
    }

    public void aqo() {
        alt();
        this.cvj.alp();
    }

    public void aqp() {
        alt();
        this.cvk.alp();
    }

    public void aqq() {
        alt();
        this.cvl.alp();
    }

    public void aqr() {
    }

    public void aqs() {
        alt();
    }

    public void aqt() {
        alt();
        this.cna.alp();
    }

    public void aqu() {
    }

    public void setFaceFocusable(boolean z) {
        this.cvj.setFocusable(z);
    }

    public void setAtFocusable(boolean z) {
        this.cvm.setFocusable(z);
    }

    public void setPrivilegeFocusable(boolean z) {
        this.cvl.setFocusable(z);
    }

    public void setBaobaoFocusable(boolean z) {
    }

    public void setFaceEnabled(boolean z) {
        this.cvj.setEnabled(z);
    }

    public void setAtEnabled(boolean z) {
        this.cvm.setEnabled(z);
    }

    public void setBaobaoEnabled(boolean z) {
    }

    public void setPrivilegeEnable(boolean z) {
    }

    public void setBaobaoEnable(boolean z) {
    }

    public void el(String str) {
        if (this.cvn == null) {
            this.cvn = a(this.cvk, true);
        } else {
            b(this.cvk, true);
        }
        this.cvk.iE(str);
    }

    public void yX() {
    }

    public void yY() {
        this.cvl.hideTip();
    }

    public void aqv() {
    }

    public void yV() {
        if (this.cvk != null) {
            b(this.cvk, true);
            this.cvk.hideTip();
        }
    }

    public void ams() {
        this.cna.hideTip();
    }

    public void amr() {
        if (this.cnc == null) {
            this.cnc = a(this.cna, false);
        }
        this.cna.displayTip();
    }

    public void fe(boolean z) {
        if (z) {
            this.cvl.Cf();
        } else {
            this.cvl.hide();
        }
    }

    public void changeSkinType(int i) {
        if (this.ajX != null) {
            ba.i((View) this.ajX, u.icon_news_head_prompt_one);
        }
        if (this.ajZ != null) {
            ba.i((View) this.ajZ, u.icon_news_down_bar_one);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.v vVar) {
        if (editorToolButton == this.cvj) {
            vVar.handleAction(1, null);
        } else if (editorToolButton == this.cvm) {
            vVar.handleAction(0, null);
        } else if (editorToolButton == this.cvk) {
            vVar.handleAction(55, null);
        } else if (editorToolButton == this.cvl) {
            vVar.handleAction(43, null);
        } else if (editorToolButton == this.cna) {
            vVar.handleAction(37, null);
        }
        if (editorToolButton.alo()) {
            if (editorToolButton.isFocused()) {
                alt();
                if (editorToolButton == this.cvj) {
                    vVar.handleAction(3, null);
                } else if (editorToolButton == this.cvm) {
                    vVar.handleAction(16, null);
                } else if (editorToolButton == this.cvk) {
                    vVar.handleAction(56, null);
                } else if (editorToolButton == this.cvl) {
                    vVar.handleAction(45, null);
                } else if (editorToolButton == this.cna) {
                    vVar.handleAction(39, null);
                }
            } else if (editorToolButton == this.cvj) {
                vVar.handleAction(2, null);
            } else if (editorToolButton == this.cvm) {
                vVar.handleAction(17, null);
            } else if (editorToolButton == this.cvk) {
                vVar.handleAction(57, null);
            } else if (editorToolButton == this.cna) {
                vVar.handleAction(38, null);
            } else if (editorToolButton == this.cvl) {
                vVar.handleAction(44, null);
            }
        }
    }

    protected View.OnClickListener b(com.baidu.tbadk.editortool.v vVar) {
        return new c(this, vVar);
    }
}
