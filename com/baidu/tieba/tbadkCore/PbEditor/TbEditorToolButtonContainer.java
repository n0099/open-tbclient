package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class TbEditorToolButtonContainer extends m {
    protected TextView Zv;
    protected TextView Zx;
    protected EditorToolButton bWW;
    protected EditorToolButton bWX;
    protected EditorToolButton bWY;
    protected EditorToolButton bWZ;
    protected EditorToolButton bWu;
    protected TextView bWw;
    protected TextView bXa;
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
        if (this.bWu != null && this.bWu.getTip() != null) {
            int intrinsicWidth = this.bWu.getDrawable().getIntrinsicWidth();
            int intrinsicHeight = this.bWu.getDrawable().getIntrinsicHeight();
            TextView tip = this.bWu.getTip();
            int right = (this.bWu.getRight() - ((this.bWu.getMeasuredWidth() - intrinsicWidth) / 2)) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 9.0f);
            int measuredHeight = (((this.bWu.getMeasuredHeight() - intrinsicHeight) / 2) + this.bWu.getTop()) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 4.0f);
            tip.layout(right, measuredHeight, tip.getMeasuredWidth() + right, tip.getMeasuredHeight() + measuredHeight);
        }
        if (this.bWY != null && this.bWY.getTip() != null) {
            int intrinsicWidth2 = this.bWY.getDrawable().getIntrinsicWidth();
            int intrinsicHeight2 = this.bWY.getDrawable().getIntrinsicHeight();
            TextView tip2 = this.bWY.getTip();
            int right2 = (this.bWY.getRight() - ((this.bWY.getMeasuredWidth() - intrinsicWidth2) / 2)) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 9.0f);
            int measuredHeight2 = (((this.bWY.getMeasuredHeight() - intrinsicHeight2) / 2) + this.bWY.getTop()) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 4.0f);
            tip2.layout(right2, measuredHeight2, tip2.getMeasuredWidth() + right2, tip2.getMeasuredHeight() + measuredHeight2);
        }
        if (this.bWX != null && this.bWX.getTip() != null) {
            int intrinsicWidth3 = this.bWX.getDrawable().getIntrinsicWidth();
            int intrinsicHeight3 = this.bWX.getDrawable().getIntrinsicHeight();
            int measuredWidth = (this.bWX.getMeasuredWidth() - intrinsicWidth3) / 2;
            int measuredHeight3 = (this.bWX.getMeasuredHeight() - intrinsicHeight3) / 2;
            TextView tip3 = this.bWX.getTip();
            if (TextUtils.isEmpty(tip3.getText())) {
                int right3 = (this.bWX.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 7.0f);
                int top = (measuredHeight3 + this.bWX.getTop()) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 0.0f);
                tip3.layout(right3, top, tip3.getMeasuredWidth() + right3, tip3.getMeasuredHeight() + top);
                return;
            }
            int right4 = (this.bWX.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 7.0f);
            int top2 = (measuredHeight3 + this.bWX.getTop()) - com.baidu.adp.lib.util.l.dip2px(this.mContext, 7.0f);
            tip3.layout(right4, top2, tip3.getMeasuredWidth() + right4, tip3.getMeasuredHeight() + top2);
        }
    }

    protected void initialize() {
        aad();
        this.bWW = (EditorToolButton) findViewById(com.baidu.tieba.w.select_face);
        this.bWZ = (EditorToolButton) findViewById(com.baidu.tieba.w.select_at);
        this.bWY = (EditorToolButton) findViewById(com.baidu.tieba.w.select_privilege);
        this.bWX = (EditorToolButton) findViewById(com.baidu.tieba.w.select_picture);
        this.bWu = (EditorToolButton) findViewById(com.baidu.tieba.w.select_more);
        this.bWu.tW();
        setDrawTop(false);
    }

    protected void aad() {
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.write_editor_tool_button_container, this, true);
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            View.OnClickListener a = a(wVar);
            this.bWW.setOnClickListener(a);
            this.bWZ.setOnClickListener(a);
            this.bWX.setOnClickListener(a);
            this.bWY.setOnClickListener(a);
            this.bWu.setOnClickListener(a);
        }
    }

    public void agE() {
        afw();
        this.bWW.afs();
    }

    public void agF() {
        afw();
        this.bWX.afs();
    }

    public void agG() {
        afw();
        this.bWY.afs();
    }

    public void agH() {
    }

    public void agI() {
        afw();
    }

    public void agJ() {
        afw();
        this.bWu.afs();
    }

    public void agK() {
    }

    public void setFaceFocusable(boolean z) {
        this.bWW.setFocusable(z);
    }

    public void setAtFocusable(boolean z) {
        this.bWZ.setFocusable(z);
    }

    public void setPrivilegeFocusable(boolean z) {
        this.bWY.setFocusable(z);
    }

    public void setBaobaoFocusable(boolean z) {
    }

    public void setFaceEnabled(boolean z) {
        this.bWW.setEnabled(z);
    }

    public void setAtEnabled(boolean z) {
        this.bWZ.setEnabled(z);
    }

    public void setBaobaoEnabled(boolean z) {
    }

    public void setPrivilegeEnable(boolean z) {
        this.bWY.setEnabled(z);
    }

    public void setBaobaoEnable(boolean z) {
    }

    public void ee(String str) {
        if (this.bXa == null) {
            this.bXa = a(this.bWX, true);
        } else {
            b(this.bWX, true);
        }
        this.bWX.ii(str);
    }

    public void vz() {
    }

    public void vA() {
        this.bWY.tW();
    }

    public void agL() {
    }

    public void vx() {
        if (this.bWX != null) {
            b(this.bWX, true);
            this.bWX.tW();
        }
    }

    public void agu() {
        this.bWu.tW();
    }

    public void agt() {
        if (this.bWw == null) {
            this.bWw = a(this.bWu, false);
        }
        this.bWu.tV();
    }

    public void ez(boolean z) {
        if (z) {
            this.bWY.yR();
        } else {
            this.bWY.hide();
        }
    }

    public void changeSkinType(int i) {
        if (this.Zv != null) {
            bc.i((View) this.Zv, com.baidu.tieba.v.icon_news_head_prompt_one);
        }
        if (this.Zx != null) {
            bc.i((View) this.Zx, com.baidu.tieba.v.icon_news_down_bar_one);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(EditorToolButton editorToolButton, com.baidu.tbadk.editortool.w wVar) {
        if (editorToolButton == this.bWW) {
            wVar.handleAction(1, null);
        } else if (editorToolButton == this.bWZ) {
            wVar.handleAction(0, null);
        } else if (editorToolButton == this.bWX) {
            wVar.handleAction(55, null);
        } else if (editorToolButton == this.bWY) {
            wVar.handleAction(43, null);
        } else if (editorToolButton == this.bWu) {
            wVar.handleAction(37, null);
        }
        if (editorToolButton.afr()) {
            if (editorToolButton.isFocused()) {
                afw();
                if (editorToolButton == this.bWW) {
                    wVar.handleAction(3, null);
                } else if (editorToolButton == this.bWZ) {
                    wVar.handleAction(16, null);
                } else if (editorToolButton == this.bWX) {
                    wVar.handleAction(56, null);
                } else if (editorToolButton == this.bWY) {
                    wVar.handleAction(45, null);
                } else if (editorToolButton == this.bWu) {
                    wVar.handleAction(39, null);
                }
            } else if (editorToolButton == this.bWW) {
                wVar.handleAction(2, null);
            } else if (editorToolButton == this.bWZ) {
                wVar.handleAction(17, null);
            } else if (editorToolButton == this.bWX) {
                wVar.handleAction(57, null);
            } else if (editorToolButton == this.bWu) {
                wVar.handleAction(38, null);
            } else if (editorToolButton == this.bWY) {
                wVar.handleAction(44, null);
            }
        }
    }

    protected View.OnClickListener a(com.baidu.tbadk.editortool.w wVar) {
        return new ax(this, wVar);
    }
}
