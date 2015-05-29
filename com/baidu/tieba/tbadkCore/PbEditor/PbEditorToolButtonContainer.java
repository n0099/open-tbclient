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
    protected EditorToolButton cqY;
    protected EditorToolButton cqZ;
    protected TextView cra;
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

    protected void aob() {
        com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.pb_editor_tool_button_container, this, true);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.cqY.getTip() != null) {
            TextView tip = this.cqY.getTip();
            int right = this.cqY.getRight() - com.baidu.adp.lib.util.n.dip2px(this.mContext, 10.0f);
            int top = this.cqY.getTop() + com.baidu.adp.lib.util.n.dip2px(this.mContext, 1.0f);
            this.cqY.getTip().layout(right, top, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + top);
        }
        if (this.cqZ.getTip() != null) {
            TextView tip2 = this.cqZ.getTip();
            int right2 = this.cqZ.getRight() - com.baidu.adp.lib.util.n.dip2px(this.mContext, 10.0f);
            int top2 = this.cqZ.getTop() + com.baidu.adp.lib.util.n.dip2px(this.mContext, 1.0f);
            this.cqZ.getTip().layout(right2, top2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + top2);
        }
    }

    protected void initialize() {
        setDrawTop(false);
        aob();
        this.cqZ = (EditorToolButton) findViewById(com.baidu.tieba.q.tool_more);
        this.cqY = (EditorToolButton) findViewById(com.baidu.tieba.q.tool_face);
        if (TbadkCoreApplication.m411getInst().isFaceShopNew()) {
            aoc();
        } else {
            zJ();
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        if (vVar != null) {
            View.OnClickListener b = b(vVar);
            this.cqZ.setOnClickListener(b);
            this.cqY.setOnClickListener(b);
        }
    }

    public void setMoreFocusable(boolean z) {
        this.cqZ.setFocusable(z);
    }

    public void setFaceFocusable(boolean z) {
        this.cqY.setFocusable(z);
    }

    public void setMoreEnabled(boolean z) {
        this.cqZ.setEnabled(z);
    }

    public void setFaceEnabled(boolean z) {
        this.cqY.setEnabled(z);
    }

    public void aoc() {
        if (this.cqY == null) {
            this.akZ = a(this.cqY, false);
        }
        this.cqY.jx("N");
    }

    public void zJ() {
        this.cqY.hideTip();
    }

    public void aod() {
        if (this.cra == null) {
            this.cra = a(this.cqZ, false);
        }
        this.cqZ.displayTip();
    }

    public void aoe() {
        this.cqZ.hideTip();
    }

    public void changeSkinType(int i) {
        if (this.akZ != null) {
            ay.i((View) this.akZ, com.baidu.tieba.p.icon_news_down_bar_one);
        }
        if (this.cra != null) {
            ay.i((View) this.cra, com.baidu.tieba.p.icon_news_down_bar_one);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.v vVar) {
        if (editorToolButton == this.cqZ) {
            vVar.handleAction(37, null);
        } else if (editorToolButton == this.cqY) {
            vVar.handleAction(1, null);
        }
        if (editorToolButton.amZ()) {
            if (!editorToolButton.isFocused()) {
                ane();
                editorToolButton.ana();
                if (editorToolButton == this.cqZ) {
                    vVar.handleAction(38, null);
                } else if (editorToolButton == this.cqY) {
                    vVar.handleAction(2, null);
                }
            } else if (editorToolButton == this.cqZ) {
                ane();
                editorToolButton.ana();
                vVar.handleAction(64, null);
            }
        }
    }

    protected View.OnClickListener b(com.baidu.tbadk.editortool.v vVar) {
        return new w(this, vVar);
    }
}
