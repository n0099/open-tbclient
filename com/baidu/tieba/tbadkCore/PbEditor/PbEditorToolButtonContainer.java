package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class PbEditorToolButtonContainer extends m {
    protected EditorToolButton bUB;
    protected EditorToolButton bUC;
    protected TextView bUD;
    protected TextView bUE;
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

    protected void Zy() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.x.pb_editor_tool_button_container, this, true);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.bUB.getTip() != null) {
            TextView tip = this.bUB.getTip();
            int right = this.bUB.getRight() - com.baidu.adp.lib.util.l.dip2px(this.mContext, 10.0f);
            int top = this.bUB.getTop() + com.baidu.adp.lib.util.l.dip2px(this.mContext, 1.0f);
            this.bUB.getTip().layout(right, top, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + top);
        }
        if (this.bUC.getTip() != null) {
            TextView tip2 = this.bUC.getTip();
            int right2 = this.bUC.getRight() - com.baidu.adp.lib.util.l.dip2px(this.mContext, 10.0f);
            int top2 = this.bUC.getTop() + com.baidu.adp.lib.util.l.dip2px(this.mContext, 1.0f);
            this.bUC.getTip().layout(right2, top2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + top2);
        }
    }

    protected void initialize() {
        setDrawTop(false);
        Zy();
        this.bUC = (EditorToolButton) findViewById(com.baidu.tieba.w.tool_more);
        this.bUB = (EditorToolButton) findViewById(com.baidu.tieba.w.tool_audio);
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            View.OnClickListener a = a(wVar);
            this.bUC.setOnClickListener(a);
            this.bUB.setOnClickListener(a);
        }
    }

    public void setMoreFocusable(boolean z) {
        this.bUC.setFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.bUB.setFocusable(z);
    }

    public void setMoreEnabled(boolean z) {
        this.bUC.setEnabled(z);
    }

    public void setAudioEnabled(boolean z) {
        this.bUB.setEnabled(z);
    }

    public void setAudioHardDisabled(boolean z) {
        this.bUB.setHardDisabled(z);
    }

    public void afN() {
        if (this.bUD == null) {
            this.bUD = a(this.bUB, false);
        }
        this.bUB.tE();
    }

    public void afO() {
        this.bUB.tF();
    }

    public void afP() {
        if (this.bUE == null) {
            this.bUE = a(this.bUC, false);
        }
        this.bUC.tE();
    }

    public void afQ() {
        this.bUC.tF();
    }

    public void er(boolean z) {
        if (z) {
            this.bUB.yB();
        } else {
            this.bUB.hide();
        }
    }

    public void changeSkinType(int i) {
        if (this.bUD != null) {
            com.baidu.tbadk.core.util.ax.i((View) this.bUD, com.baidu.tieba.v.icon_news_down_bar_one);
        }
        if (this.bUE != null) {
            com.baidu.tbadk.core.util.ax.i((View) this.bUE, com.baidu.tieba.v.icon_news_down_bar_one);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.w wVar) {
        if (editorToolButton == this.bUC) {
            wVar.handleAction(37, null);
        } else if (editorToolButton == this.bUB) {
            wVar.handleAction(4, null);
        }
        if (editorToolButton.aeN() && !editorToolButton.isFocused()) {
            aeS();
            editorToolButton.aeO();
            if (editorToolButton == this.bUC) {
                wVar.handleAction(38, null);
            } else if (editorToolButton == this.bUB) {
                wVar.handleAction(5, null);
            }
        }
    }

    protected View.OnClickListener a(com.baidu.tbadk.editortool.w wVar) {
        return new af(this, wVar);
    }
}
