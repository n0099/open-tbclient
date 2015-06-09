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
    protected EditorToolButton cqZ;
    protected EditorToolButton cra;
    protected TextView crb;
    protected EditorToolButton czC;
    protected EditorToolButton czD;
    protected EditorToolButton czE;
    protected TextView czF;
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
        if (this.cra != null && this.cra.getTip() != null) {
            int intrinsicWidth = this.cra.getDrawable().getIntrinsicWidth();
            int intrinsicHeight = this.cra.getDrawable().getIntrinsicHeight();
            TextView tip = this.cra.getTip();
            int right = (this.cra.getRight() - ((this.cra.getMeasuredWidth() - intrinsicWidth) / 2)) - n.dip2px(this.mContext, 9.0f);
            int measuredHeight = (((this.cra.getMeasuredHeight() - intrinsicHeight) / 2) + this.cra.getTop()) - n.dip2px(this.mContext, 4.0f);
            tip.layout(right, measuredHeight, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + measuredHeight);
        }
        if (this.czD != null && this.czD.getTip() != null) {
            int intrinsicWidth2 = this.czD.getDrawable().getIntrinsicWidth();
            int intrinsicHeight2 = this.czD.getDrawable().getIntrinsicHeight();
            TextView tip2 = this.czD.getTip();
            int right2 = (this.czD.getRight() - ((this.czD.getMeasuredWidth() - intrinsicWidth2) / 2)) - n.dip2px(this.mContext, 9.0f);
            int measuredHeight2 = (((this.czD.getMeasuredHeight() - intrinsicHeight2) / 2) + this.czD.getTop()) - n.dip2px(this.mContext, 4.0f);
            tip2.layout(right2, measuredHeight2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + measuredHeight2);
        }
        if (this.czC != null && this.czC.getTip() != null) {
            int intrinsicWidth3 = this.czC.getDrawable().getIntrinsicWidth();
            int intrinsicHeight3 = this.czC.getDrawable().getIntrinsicHeight();
            int measuredWidth = (this.czC.getMeasuredWidth() - intrinsicWidth3) / 2;
            int measuredHeight3 = (this.czC.getMeasuredHeight() - intrinsicHeight3) / 2;
            TextView tip3 = this.czC.getTip();
            if (TextUtils.isEmpty(tip3.getText())) {
                int right3 = (this.czC.getRight() - measuredWidth) - n.dip2px(this.mContext, 7.0f);
                int top = (measuredHeight3 + this.czC.getTop()) - n.dip2px(this.mContext, 0.0f);
                tip3.layout(right3, top, tip3.getMeasuredWidth() + right3, tip3.getMeasuredHeight() + top);
                return;
            }
            int right4 = (this.czC.getRight() - measuredWidth) - n.dip2px(this.mContext, 7.0f);
            int top2 = (measuredHeight3 + this.czC.getTop()) - n.dip2px(this.mContext, 7.0f);
            tip3.layout(right4, top2, tip3.getMeasuredWidth() + right4, tip3.getMeasuredHeight() + top2);
        }
    }

    protected void initialize() {
        aoc();
        this.cqZ = (EditorToolButton) findViewById(q.select_face);
        this.czE = (EditorToolButton) findViewById(q.select_at);
        this.czD = (EditorToolButton) findViewById(q.select_privilege);
        this.czC = (EditorToolButton) findViewById(q.select_picture);
        this.cra = (EditorToolButton) findViewById(q.select_more);
        this.cra.hideTip();
        setDrawTop(false);
    }

    protected void aoc() {
        com.baidu.adp.lib.g.b.hr().a(this.mContext, r.write_editor_tool_button_container, this, true);
    }

    public void setOnActionListener(v vVar) {
        if (vVar != null) {
            View.OnClickListener b = b(vVar);
            this.cqZ.setOnClickListener(b);
            this.czE.setOnClickListener(b);
            this.czC.setOnClickListener(b);
            this.czD.setOnClickListener(b);
            this.cra.setOnClickListener(b);
        }
    }

    public void asf() {
        anf();
        this.cqZ.anb();
    }

    public void asg() {
        anf();
        this.czC.anb();
    }

    public void ash() {
        anf();
        this.czD.anb();
    }

    public void asi() {
    }

    public void asj() {
        anf();
    }

    public void ask() {
        anf();
        this.cra.anb();
    }

    public void asl() {
    }

    public void setFaceFocusable(boolean z) {
        this.cqZ.setFocusable(z);
    }

    public void setAtFocusable(boolean z) {
        this.czE.setFocusable(z);
    }

    public void setPrivilegeFocusable(boolean z) {
        this.czD.setFocusable(z);
    }

    public void setBaobaoFocusable(boolean z) {
    }

    public void setFaceEnabled(boolean z) {
        this.cqZ.setEnabled(z);
    }

    public void setAtEnabled(boolean z) {
        this.czE.setEnabled(z);
    }

    public void setBaobaoEnabled(boolean z) {
    }

    public void setPrivilegeEnable(boolean z) {
    }

    public void setBaobaoEnable(boolean z) {
    }

    public void eC(String str) {
        if (this.czF == null) {
            this.czF = a(this.czC, true);
        } else {
            b(this.czC, true);
        }
        this.czC.jx(str);
    }

    public void zL() {
    }

    public void zM() {
        this.czD.hideTip();
    }

    public void asm() {
    }

    public void zJ() {
        if (this.czC != null) {
            b(this.czC, true);
            this.czC.hideTip();
        }
    }

    public void aof() {
        this.cra.hideTip();
    }

    public void aoe() {
        if (this.crb == null) {
            this.crb = a(this.cra, false);
        }
        this.cra.displayTip();
    }

    public void fA(boolean z) {
        if (z) {
            this.czD.CR();
        } else {
            this.czD.hide();
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
        if (editorToolButton == this.cqZ) {
            vVar.handleAction(1, null);
        } else if (editorToolButton == this.czE) {
            vVar.handleAction(0, null);
        } else if (editorToolButton == this.czC) {
            vVar.handleAction(55, null);
        } else if (editorToolButton == this.czD) {
            TiebaStatic.eventStat(getContext(), "consume_17", "click");
            vVar.handleAction(43, null);
        } else if (editorToolButton == this.cra) {
            vVar.handleAction(37, null);
        }
        if (editorToolButton.ana()) {
            if (editorToolButton.isFocused()) {
                anf();
                if (editorToolButton == this.cqZ) {
                    vVar.handleAction(3, null);
                } else if (editorToolButton == this.czE) {
                    vVar.handleAction(16, null);
                } else if (editorToolButton == this.czC) {
                    vVar.handleAction(56, null);
                } else if (editorToolButton == this.czD) {
                    vVar.handleAction(45, null);
                } else if (editorToolButton == this.cra) {
                    vVar.handleAction(39, null);
                }
            } else if (editorToolButton == this.cqZ) {
                vVar.handleAction(2, null);
            } else if (editorToolButton == this.czE) {
                vVar.handleAction(17, null);
            } else if (editorToolButton == this.czC) {
                vVar.handleAction(57, null);
            } else if (editorToolButton == this.cra) {
                vVar.handleAction(38, null);
            } else if (editorToolButton == this.czD) {
                vVar.handleAction(44, null);
            }
        }
    }

    protected View.OnClickListener b(v vVar) {
        return new c(this, vVar);
    }
}
