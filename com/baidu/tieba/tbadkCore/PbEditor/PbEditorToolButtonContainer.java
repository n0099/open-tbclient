package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class PbEditorToolButtonContainer extends m {
    protected EditorToolButton bWt;
    protected EditorToolButton bWu;
    protected TextView bWv;
    protected TextView bWw;
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

    protected void aad() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.pb_editor_tool_button_container, this, true);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.bWt.getTip() != null) {
            TextView tip = this.bWt.getTip();
            int right = this.bWt.getRight() - com.baidu.adp.lib.util.l.dip2px(this.mContext, 10.0f);
            int top = this.bWt.getTop() + com.baidu.adp.lib.util.l.dip2px(this.mContext, 1.0f);
            this.bWt.getTip().layout(right, top, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + top);
        }
        if (this.bWu.getTip() != null) {
            TextView tip2 = this.bWu.getTip();
            int right2 = this.bWu.getRight() - com.baidu.adp.lib.util.l.dip2px(this.mContext, 10.0f);
            int top2 = this.bWu.getTop() + com.baidu.adp.lib.util.l.dip2px(this.mContext, 1.0f);
            this.bWu.getTip().layout(right2, top2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + top2);
        }
    }

    protected void initialize() {
        setDrawTop(false);
        aad();
        this.bWu = (EditorToolButton) findViewById(com.baidu.tieba.w.tool_more);
        this.bWt = (EditorToolButton) findViewById(com.baidu.tieba.w.tool_audio);
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            View.OnClickListener a = a(wVar);
            this.bWu.setOnClickListener(a);
            this.bWt.setOnClickListener(a);
        }
    }

    public void setMoreFocusable(boolean z) {
        this.bWu.setFocusable(z);
    }

    public void setAudioFocusable(boolean z) {
        this.bWt.setFocusable(z);
    }

    public void setMoreEnabled(boolean z) {
        this.bWu.setEnabled(z);
    }

    public void setAudioEnabled(boolean z) {
        this.bWt.setEnabled(z);
    }

    public void setAudioHardDisabled(boolean z) {
        this.bWt.setHardDisabled(z);
    }

    public void agr() {
        if (this.bWv == null) {
            this.bWv = a(this.bWt, false);
        }
        this.bWt.tV();
    }

    public void ags() {
        this.bWt.tW();
    }

    public void agt() {
        if (this.bWw == null) {
            this.bWw = a(this.bWu, false);
        }
        this.bWu.tV();
    }

    public void agu() {
        this.bWu.tW();
    }

    public void ey(boolean z) {
        if (z) {
            this.bWt.yR();
        } else {
            this.bWt.hide();
        }
    }

    public void changeSkinType(int i) {
        if (this.bWv != null) {
            bc.i((View) this.bWv, com.baidu.tieba.v.icon_news_down_bar_one);
        }
        if (this.bWw != null) {
            bc.i((View) this.bWw, com.baidu.tieba.v.icon_news_down_bar_one);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.w wVar) {
        if (editorToolButton == this.bWu) {
            wVar.handleAction(37, null);
        } else if (editorToolButton == this.bWt) {
            wVar.handleAction(4, null);
        }
        if (editorToolButton.afr() && !editorToolButton.isFocused()) {
            afw();
            editorToolButton.afs();
            if (editorToolButton == this.bWu) {
                wVar.handleAction(38, null);
            } else if (editorToolButton == this.bWt) {
                wVar.handleAction(5, null);
            }
        }
    }

    protected View.OnClickListener a(com.baidu.tbadk.editortool.w wVar) {
        return new af(this, wVar);
    }
}
