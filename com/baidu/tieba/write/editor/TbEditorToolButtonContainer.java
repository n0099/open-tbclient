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
    protected TextView ajP;
    protected TextView ajR;
    protected EditorToolButton cmK;
    protected TextView cmM;
    protected EditorToolButton cuT;
    protected EditorToolButton cuU;
    protected EditorToolButton cuV;
    protected EditorToolButton cuW;
    protected TextView cuX;
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
        if (this.cmK != null && this.cmK.getTip() != null) {
            int intrinsicWidth = this.cmK.getDrawable().getIntrinsicWidth();
            int intrinsicHeight = this.cmK.getDrawable().getIntrinsicHeight();
            TextView tip = this.cmK.getTip();
            int right = (this.cmK.getRight() - ((this.cmK.getMeasuredWidth() - intrinsicWidth) / 2)) - n.dip2px(this.mContext, 9.0f);
            int measuredHeight = (((this.cmK.getMeasuredHeight() - intrinsicHeight) / 2) + this.cmK.getTop()) - n.dip2px(this.mContext, 4.0f);
            tip.layout(right, measuredHeight, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + measuredHeight);
        }
        if (this.cuV != null && this.cuV.getTip() != null) {
            int intrinsicWidth2 = this.cuV.getDrawable().getIntrinsicWidth();
            int intrinsicHeight2 = this.cuV.getDrawable().getIntrinsicHeight();
            TextView tip2 = this.cuV.getTip();
            int right2 = (this.cuV.getRight() - ((this.cuV.getMeasuredWidth() - intrinsicWidth2) / 2)) - n.dip2px(this.mContext, 9.0f);
            int measuredHeight2 = (((this.cuV.getMeasuredHeight() - intrinsicHeight2) / 2) + this.cuV.getTop()) - n.dip2px(this.mContext, 4.0f);
            tip2.layout(right2, measuredHeight2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + measuredHeight2);
        }
        if (this.cuU != null && this.cuU.getTip() != null) {
            int intrinsicWidth3 = this.cuU.getDrawable().getIntrinsicWidth();
            int intrinsicHeight3 = this.cuU.getDrawable().getIntrinsicHeight();
            int measuredWidth = (this.cuU.getMeasuredWidth() - intrinsicWidth3) / 2;
            int measuredHeight3 = (this.cuU.getMeasuredHeight() - intrinsicHeight3) / 2;
            TextView tip3 = this.cuU.getTip();
            if (TextUtils.isEmpty(tip3.getText())) {
                int right3 = (this.cuU.getRight() - measuredWidth) - n.dip2px(this.mContext, 7.0f);
                int top = (measuredHeight3 + this.cuU.getTop()) - n.dip2px(this.mContext, 0.0f);
                tip3.layout(right3, top, tip3.getMeasuredWidth() + right3, tip3.getMeasuredHeight() + top);
                return;
            }
            int right4 = (this.cuU.getRight() - measuredWidth) - n.dip2px(this.mContext, 7.0f);
            int top2 = (measuredHeight3 + this.cuU.getTop()) - n.dip2px(this.mContext, 7.0f);
            tip3.layout(right4, top2, tip3.getMeasuredWidth() + right4, tip3.getMeasuredHeight() + top2);
        }
    }

    protected void initialize() {
        aci();
        this.cuT = (EditorToolButton) findViewById(v.select_face);
        this.cuW = (EditorToolButton) findViewById(v.select_at);
        this.cuV = (EditorToolButton) findViewById(v.select_privilege);
        this.cuU = (EditorToolButton) findViewById(v.select_picture);
        this.cmK = (EditorToolButton) findViewById(v.select_more);
        this.cmK.hideTip();
        setDrawTop(false);
    }

    protected void aci() {
        com.baidu.adp.lib.g.b.hH().a(this.mContext, w.write_editor_tool_button_container, this, true);
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        if (vVar != null) {
            View.OnClickListener b = b(vVar);
            this.cuT.setOnClickListener(b);
            this.cuW.setOnClickListener(b);
            this.cuU.setOnClickListener(b);
            this.cuV.setOnClickListener(b);
            this.cmK.setOnClickListener(b);
        }
    }

    public void apZ() {
        ale();
        this.cuT.ala();
    }

    public void aqa() {
        ale();
        this.cuU.ala();
    }

    public void aqb() {
        ale();
        this.cuV.ala();
    }

    public void aqc() {
    }

    public void aqd() {
        ale();
    }

    public void aqe() {
        ale();
        this.cmK.ala();
    }

    public void aqf() {
    }

    public void setFaceFocusable(boolean z) {
        this.cuT.setFocusable(z);
    }

    public void setAtFocusable(boolean z) {
        this.cuW.setFocusable(z);
    }

    public void setPrivilegeFocusable(boolean z) {
        this.cuV.setFocusable(z);
    }

    public void setBaobaoFocusable(boolean z) {
    }

    public void setFaceEnabled(boolean z) {
        this.cuT.setEnabled(z);
    }

    public void setAtEnabled(boolean z) {
        this.cuW.setEnabled(z);
    }

    public void setBaobaoEnabled(boolean z) {
    }

    public void setPrivilegeEnable(boolean z) {
    }

    public void setBaobaoEnable(boolean z) {
    }

    public void ei(String str) {
        if (this.cuX == null) {
            this.cuX = a(this.cuU, true);
        } else {
            b(this.cuU, true);
        }
        this.cuU.iB(str);
    }

    public void yR() {
    }

    public void yS() {
        this.cuV.hideTip();
    }

    public void aqg() {
    }

    public void yP() {
        if (this.cuU != null) {
            b(this.cuU, true);
            this.cuU.hideTip();
        }
    }

    public void amd() {
        this.cmK.hideTip();
    }

    public void amc() {
        if (this.cmM == null) {
            this.cmM = a(this.cmK, false);
        }
        this.cmK.displayTip();
    }

    public void fg(boolean z) {
        if (z) {
            this.cuV.BZ();
        } else {
            this.cuV.hide();
        }
    }

    public void changeSkinType(int i) {
        if (this.ajP != null) {
            ba.i((View) this.ajP, u.icon_news_head_prompt_one);
        }
        if (this.ajR != null) {
            ba.i((View) this.ajR, u.icon_news_down_bar_one);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.v vVar) {
        if (editorToolButton == this.cuT) {
            vVar.handleAction(1, null);
        } else if (editorToolButton == this.cuW) {
            vVar.handleAction(0, null);
        } else if (editorToolButton == this.cuU) {
            vVar.handleAction(55, null);
        } else if (editorToolButton == this.cuV) {
            vVar.handleAction(43, null);
        } else if (editorToolButton == this.cmK) {
            vVar.handleAction(37, null);
        }
        if (editorToolButton.akZ()) {
            if (editorToolButton.isFocused()) {
                ale();
                if (editorToolButton == this.cuT) {
                    vVar.handleAction(3, null);
                } else if (editorToolButton == this.cuW) {
                    vVar.handleAction(16, null);
                } else if (editorToolButton == this.cuU) {
                    vVar.handleAction(56, null);
                } else if (editorToolButton == this.cuV) {
                    vVar.handleAction(45, null);
                } else if (editorToolButton == this.cmK) {
                    vVar.handleAction(39, null);
                }
            } else if (editorToolButton == this.cuT) {
                vVar.handleAction(2, null);
            } else if (editorToolButton == this.cuW) {
                vVar.handleAction(17, null);
            } else if (editorToolButton == this.cuU) {
                vVar.handleAction(57, null);
            } else if (editorToolButton == this.cmK) {
                vVar.handleAction(38, null);
            } else if (editorToolButton == this.cuV) {
                vVar.handleAction(44, null);
            }
        }
    }

    protected View.OnClickListener b(com.baidu.tbadk.editortool.v vVar) {
        return new c(this, vVar);
    }
}
