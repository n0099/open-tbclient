package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.baidu.tieba.write.editor.b;
/* loaded from: classes2.dex */
public class a extends RelativeLayout implements s {
    private i IT;
    private int IU;
    private boolean dFW;
    private b hec;
    private StateSwitchView hed;
    private StateSwitchView hee;
    private String hef;
    private String mFrom;

    public a(Context context, String str) {
        this(context, str, null);
    }

    public a(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dFW = true;
        int dimension = (int) context.getResources().getDimension(d.e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.hef = str;
        cj(context);
        ck(context);
        cl(context);
    }

    private void cj(Context context) {
        this.hec = new b(context);
        this.hec.setId(d.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        this.hec.setLocationClickListener(new b.a() { // from class: com.baidu.tieba.write.editor.a.1
            @Override // com.baidu.tieba.write.editor.b.a
            public void bFY() {
                a.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.b.a
            public void bFZ() {
                a.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                a.this.hec.hide();
            }
        });
        addView(this.hec, layoutParams);
    }

    private void ck(Context context) {
        this.hed = new StateSwitchView(context);
        this.hed.setId(d.g.view_write_thread_add_title);
        this.hed.cp(getResources().getString(d.j.write_add_title), getResources().getString(d.j.write_hide_title));
        this.hed.setBackgroundId(d.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        layoutParams.addRule(1, d.g.editor_id_location);
        this.hed.setLayoutParams(layoutParams);
        this.hed.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hed.getState() == 0) {
                    a.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    a.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                a.this.hed.bGa();
            }
        });
        addView(this.hed);
    }

    private void cl(Context context) {
        this.hee = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.hee.setLayoutParams(layoutParams);
        this.hee.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(a.this.mFrom)) {
                    if ("1".equals(a.this.hef)) {
                        TiebaStatic.log(new ak("c12608").r("obj_locate", 6));
                    } else if ("2".equals(a.this.hef)) {
                        TiebaStatic.log(new ak("c12608").r("obj_locate", 5));
                    }
                }
                a.this.hee.bGa();
            }
        });
        if ("1".equals(this.hef)) {
            this.hee.cp(getResources().getString(d.j.public_to_all), getResources().getString(d.j.public_to_me));
            this.hee.setBackgroundId(d.f.state_switch_bg);
        } else if ("2".equals(this.hef)) {
            this.hee.cp(getResources().getString(d.j.display_to_home_page), getResources().getString(d.j.display_to_home_page));
            this.hee.cg(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
            this.hee.setPadding(this.hee.getPaddingLeft(), 0, 0, 0);
            this.hee.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds28));
        }
        addView(this.hee);
    }

    public boolean isPrivacy() {
        return (this.hee == null || this.hee.getState() != 0) && this.hee != null && this.hee.getState() == 1;
    }

    public void aWg() {
        if (this.hee != null) {
            this.hee.hideTip();
        }
    }

    public void bFW() {
        if (this.hed != null) {
            this.hed.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar == null) {
            return;
        }
        switch (aVar.code) {
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case d.l.View_hapticFeedbackEnabled /* 46 */:
            case 49:
            default:
                return;
            case 19:
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.d.a)) {
                    com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                    if (aVar2 != null && aVar2.aDs) {
                        this.hec.k(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.hec.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.hec.hide();
                return;
            case 21:
                this.hed.setState(1);
                return;
            case d.l.View_transformPivotY /* 54 */:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    private void bFX() {
        String string;
        String sharedPrefKeyWithAccount;
        if (this.hee != null) {
            if ("1".equals(this.hef)) {
                string = getResources().getString(d.j.privacy_tip_one);
                sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_privacy_tip_one");
            } else if ("2".equals(this.hef)) {
                string = getResources().getString(d.j.privacy_tip_two);
                sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_privacy_tip_two");
            } else {
                return;
            }
            this.hee.cq(string, sharedPrefKeyWithAccount);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lE() {
        if (this.dFW) {
            this.dFW = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
        bFX();
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IU;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        aWg();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        if (this.hed != null) {
            this.hed.onChangeSkinType(i);
        }
        if (this.hec != null) {
            this.hec.onChangeSkinType(i);
        }
        if (this.hee != null) {
            this.hee.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IT != null) {
            this.IT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.IT = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IU = i;
    }
}
