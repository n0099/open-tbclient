package com.baidu.tieba.write.editor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.editortool.v;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolButton;
/* loaded from: classes.dex */
public class TbEditorToolButtonContainer extends com.baidu.tieba.tbadkCore.PbEditor.c {
    protected TextView akY;
    protected TextView ala;
    protected EditorToolButton cqY;
    protected EditorToolButton cqZ;
    protected TextView cra;
    protected EditorToolButton czB;
    protected EditorToolButton czC;
    protected EditorToolButton czD;
    protected TextView czE;
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
        if (this.cqZ != null && this.cqZ.getTip() != null) {
            int intrinsicWidth = this.cqZ.getDrawable().getIntrinsicWidth();
            int intrinsicHeight = this.cqZ.getDrawable().getIntrinsicHeight();
            TextView tip = this.cqZ.getTip();
            int right = (this.cqZ.getRight() - ((this.cqZ.getMeasuredWidth() - intrinsicWidth) / 2)) - n.dip2px(this.mContext, 9.0f);
            int measuredHeight = (((this.cqZ.getMeasuredHeight() - intrinsicHeight) / 2) + this.cqZ.getTop()) - n.dip2px(this.mContext, 4.0f);
            tip.layout(right, measuredHeight, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + measuredHeight);
        }
        if (this.czC != null && this.czC.getTip() != null) {
            int intrinsicWidth2 = this.czC.getDrawable().getIntrinsicWidth();
            int intrinsicHeight2 = this.czC.getDrawable().getIntrinsicHeight();
            TextView tip2 = this.czC.getTip();
            int right2 = (this.czC.getRight() - ((this.czC.getMeasuredWidth() - intrinsicWidth2) / 2)) - n.dip2px(this.mContext, 9.0f);
            int measuredHeight2 = (((this.czC.getMeasuredHeight() - intrinsicHeight2) / 2) + this.czC.getTop()) - n.dip2px(this.mContext, 4.0f);
            tip2.layout(right2, measuredHeight2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + measuredHeight2);
        }
        if (this.czB != null && this.czB.getTip() != null) {
            int intrinsicWidth3 = this.czB.getDrawable().getIntrinsicWidth();
            int intrinsicHeight3 = this.czB.getDrawable().getIntrinsicHeight();
            int measuredWidth = (this.czB.getMeasuredWidth() - intrinsicWidth3) / 2;
            int measuredHeight3 = (this.czB.getMeasuredHeight() - intrinsicHeight3) / 2;
            TextView tip3 = this.czB.getTip();
            if (TextUtils.isEmpty(tip3.getText())) {
                int right3 = (this.czB.getRight() - measuredWidth) - n.dip2px(this.mContext, 7.0f);
                int top = (measuredHeight3 + this.czB.getTop()) - n.dip2px(this.mContext, 0.0f);
                tip3.layout(right3, top, tip3.getMeasuredWidth() + right3, tip3.getMeasuredHeight() + top);
                return;
            }
            int right4 = (this.czB.getRight() - measuredWidth) - n.dip2px(this.mContext, 7.0f);
            int top2 = (measuredHeight3 + this.czB.getTop()) - n.dip2px(this.mContext, 7.0f);
            tip3.layout(right4, top2, tip3.getMeasuredWidth() + right4, tip3.getMeasuredHeight() + top2);
        }
    }

    protected void initialize() {
        aob();
        this.cqY = (EditorToolButton) findViewById(q.select_face);
        this.czD = (EditorToolButton) findViewById(q.select_at);
        this.czC = (EditorToolButton) findViewById(q.select_privilege);
        this.czB = (EditorToolButton) findViewById(q.select_picture);
        this.cqZ = (EditorToolButton) findViewById(q.select_more);
        this.cqZ.hideTip();
        setDrawTop(false);
    }

    protected void aob() {
        com.baidu.adp.lib.g.b.hr().a(this.mContext, r.write_editor_tool_button_container, this, true);
    }

    public void setOnActionListener(v vVar) {
        if (vVar != null) {
            View.OnClickListener b = b(vVar);
            this.cqY.setOnClickListener(b);
            this.czD.setOnClickListener(b);
            this.czB.setOnClickListener(b);
            this.czC.setOnClickListener(b);
            this.cqZ.setOnClickListener(b);
        }
    }

    public void ase() {
        ane();
        this.cqY.ana();
    }

    public void asf() {
        ane();
        this.czB.ana();
    }

    public void asg() {
        ane();
        this.czC.ana();
    }

    public void ash() {
    }

    public void asi() {
        ane();
    }

    public void asj() {
        ane();
        this.cqZ.ana();
    }

    public void ask() {
    }

    public void setFaceFocusable(boolean z) {
        this.cqY.setFocusable(z);
    }

    public void setAtFocusable(boolean z) {
        this.czD.setFocusable(z);
    }

    public void setPrivilegeFocusable(boolean z) {
        this.czC.setFocusable(z);
    }

    public void setBaobaoFocusable(boolean z) {
    }

    public void setFaceEnabled(boolean z) {
        this.cqY.setEnabled(z);
    }

    public void setAtEnabled(boolean z) {
        this.czD.setEnabled(z);
    }

    public void setBaobaoEnabled(boolean z) {
    }

    public void setPrivilegeEnable(boolean z) {
    }

    public void setBaobaoEnable(boolean z) {
    }

    public void eC(String str) {
        if (this.czE == null) {
            this.czE = a(this.czB, true);
        } else {
            b(this.czB, true);
        }
        this.czB.jx(str);
    }

    public void zK() {
    }

    public void zL() {
        this.czC.hideTip();
    }

    public void asl() {
    }

    public void zI() {
        if (this.czB != null) {
            b(this.czB, true);
            this.czB.hideTip();
        }
    }

    public void aoe() {
        this.cqZ.hideTip();
    }

    public void aod() {
        if (this.cra == null) {
            this.cra = a(this.cqZ, false);
        }
        this.cqZ.displayTip();
    }

    public void fA(boolean z) {
        if (z) {
            this.czC.CQ();
        } else {
            this.czC.hide();
        }
    }

    public void changeSkinType(int i) {
        if (this.akY != null) {
            ay.i((View) this.akY, p.icon_news_head_prompt_one);
        }
        if (this.ala != null) {
            ay.i((View) this.ala, p.icon_news_down_bar_one);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, v vVar) {
        if (editorToolButton == this.cqY) {
            vVar.handleAction(1, null);
        } else if (editorToolButton == this.czD) {
            vVar.handleAction(0, null);
        } else if (editorToolButton == this.czB) {
            vVar.handleAction(55, null);
        } else if (editorToolButton == this.czC) {
            TiebaStatic.eventStat(getContext(), "consume_17", "click");
            vVar.handleAction(43, null);
        } else if (editorToolButton == this.cqZ) {
            vVar.handleAction(37, null);
        }
        if (editorToolButton.amZ()) {
            if (editorToolButton.isFocused()) {
                ane();
                if (editorToolButton == this.cqY) {
                    vVar.handleAction(3, null);
                } else if (editorToolButton == this.czD) {
                    vVar.handleAction(16, null);
                } else if (editorToolButton == this.czB) {
                    vVar.handleAction(56, null);
                } else if (editorToolButton == this.czC) {
                    vVar.handleAction(45, null);
                } else if (editorToolButton == this.cqZ) {
                    vVar.handleAction(39, null);
                }
            } else if (editorToolButton == this.cqY) {
                vVar.handleAction(2, null);
            } else if (editorToolButton == this.czD) {
                vVar.handleAction(17, null);
            } else if (editorToolButton == this.czB) {
                vVar.handleAction(57, null);
            } else if (editorToolButton == this.cqZ) {
                vVar.handleAction(38, null);
            } else if (editorToolButton == this.czC) {
                vVar.handleAction(44, null);
            }
        }
    }

    protected View.OnClickListener b(v vVar) {
        return new c(this, vVar);
    }
}
