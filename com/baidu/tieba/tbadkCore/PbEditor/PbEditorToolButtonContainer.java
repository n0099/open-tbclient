package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class PbEditorToolButtonContainer extends c {
    protected TextView akZ;
    protected EditorToolButton cqZ;
    protected EditorToolButton cra;
    protected TextView crb;
    protected Context mContext;

    public PbEditorToolButtonContainer(Context context) {
        super(context);
        this.mContext = context;
        initialize();
    }

    public PbEditorToolButtonContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initialize();
    }

    public PbEditorToolButtonContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initialize();
    }

    protected void aoc() {
        com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.pb_editor_tool_button_container, this, true);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.cqZ.getTip() != null) {
            TextView tip = this.cqZ.getTip();
            int right = this.cqZ.getRight() - com.baidu.adp.lib.util.n.dip2px(this.mContext, 10.0f);
            int top = this.cqZ.getTop() + com.baidu.adp.lib.util.n.dip2px(this.mContext, 1.0f);
            this.cqZ.getTip().layout(right, top, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + top);
        }
        if (this.cra.getTip() != null) {
            TextView tip2 = this.cra.getTip();
            int right2 = this.cra.getRight() - com.baidu.adp.lib.util.n.dip2px(this.mContext, 10.0f);
            int top2 = this.cra.getTop() + com.baidu.adp.lib.util.n.dip2px(this.mContext, 1.0f);
            this.cra.getTip().layout(right2, top2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + top2);
        }
    }

    protected void initialize() {
        setDrawTop(false);
        aoc();
        this.cra = (EditorToolButton) findViewById(com.baidu.tieba.q.tool_more);
        this.cqZ = (EditorToolButton) findViewById(com.baidu.tieba.q.tool_face);
        if (TbadkCoreApplication.m411getInst().isFaceShopNew()) {
            aod();
        } else {
            zK();
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        if (vVar != null) {
            View.OnClickListener b = b(vVar);
            this.cra.setOnClickListener(b);
            this.cqZ.setOnClickListener(b);
        }
    }

    public void setMoreFocusable(boolean z) {
        this.cra.setFocusable(z);
    }

    public void setFaceFocusable(boolean z) {
        this.cqZ.setFocusable(z);
    }

    public void setMoreEnabled(boolean z) {
        this.cra.setEnabled(z);
    }

    public void setFaceEnabled(boolean z) {
        this.cqZ.setEnabled(z);
    }

    public void aod() {
        if (this.cqZ == null) {
            this.akZ = a(this.cqZ, false);
        }
        this.cqZ.jx("N");
    }

    public void zK() {
        this.cqZ.hideTip();
    }

    public void aoe() {
        if (this.crb == null) {
            this.crb = a(this.cra, false);
        }
        this.cra.displayTip();
    }

    public void aof() {
        this.cra.hideTip();
    }

    public void changeSkinType(int i) {
        if (this.akZ != null) {
            ay.i((View) this.akZ, com.baidu.tieba.p.icon_news_down_bar_one);
        }
        if (this.crb != null) {
            ay.i((View) this.crb, com.baidu.tieba.p.icon_news_down_bar_one);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.v vVar) {
        if (editorToolButton == this.cra) {
            vVar.handleAction(37, null);
        } else if (editorToolButton == this.cqZ) {
            vVar.handleAction(1, null);
        }
        if (editorToolButton.ana()) {
            if (!editorToolButton.isFocused()) {
                anf();
                editorToolButton.anb();
                if (editorToolButton == this.cra) {
                    vVar.handleAction(38, null);
                } else if (editorToolButton == this.cqZ) {
                    vVar.handleAction(2, null);
                }
            } else if (editorToolButton == this.cra) {
                anf();
                editorToolButton.anb();
                vVar.handleAction(64, null);
            }
        }
    }

    protected View.OnClickListener b(com.baidu.tbadk.editortool.v vVar) {
        return new w(this, vVar);
    }
}
