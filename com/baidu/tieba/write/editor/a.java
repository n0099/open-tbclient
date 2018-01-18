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
import com.baidu.tieba.write.editor.c;
/* loaded from: classes2.dex */
public class a extends RelativeLayout implements s {
    private i axN;
    private int axO;
    private boolean euI;
    private b hEG;
    private StateSwitchView hEH;
    private StateSwitchView hEI;
    private String hnU;
    private String mForumId;
    private String mFrom;

    public a(Context context, String str) {
        this(context, str, null);
    }

    public a(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.euI = true;
        int dimension = (int) context.getResources().getDimension(d.e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.hnU = str;
        cp(context);
        cq(context);
        cr(context);
    }

    private void cp(Context context) {
        this.hEG = new b(context);
        this.hEG.setId(d.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        this.hEG.setLocationClickListener(new b.a() { // from class: com.baidu.tieba.write.editor.a.1
            @Override // com.baidu.tieba.write.editor.b.a
            public void bFX() {
                a.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.b.a
            public void bFY() {
                a.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                a.this.hEG.hide();
            }
        });
        addView(this.hEG, layoutParams);
    }

    private void cq(Context context) {
        this.hEH = new StateSwitchView(context);
        this.hEH.setId(d.g.view_write_thread_add_title);
        this.hEH.cl(getResources().getString(d.j.write_add_title), getResources().getString(d.j.write_hide_title));
        this.hEH.setBackgroundId(d.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        layoutParams.addRule(1, d.g.editor_id_location);
        this.hEH.setLayoutParams(layoutParams);
        this.hEH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hEH.getState() == 0) {
                    a.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    a.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                a.this.hEH.bFZ();
            }
        });
        addView(this.hEH);
    }

    private void cr(Context context) {
        this.hEI = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.hEI.setLayoutParams(layoutParams);
        this.hEI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(a.this.mFrom)) {
                    if ("1".equals(a.this.hnU)) {
                        TiebaStatic.log(new ak("c12608").s("obj_locate", 6));
                    } else if ("2".equals(a.this.hnU)) {
                        TiebaStatic.log(new ak("c12608").s("obj_locate", 5));
                    }
                }
                a.this.hEI.bFZ();
                if ("2".equals(a.this.hnU)) {
                    c.aO(a.this.mForumId, a.this.hEI.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.hnU)) {
            this.hEI.cl(getResources().getString(d.j.public_to_all), getResources().getString(d.j.public_to_me));
            this.hEI.setBackgroundId(d.f.state_switch_bg);
        } else if ("2".equals(this.hnU)) {
            this.hEI.cl(getResources().getString(d.j.display_to_home_page), getResources().getString(d.j.display_to_home_page));
            this.hEI.cX(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
            this.hEI.setPadding(this.hEI.getPaddingLeft(), 0, 0, 0);
            this.hEI.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds28));
        }
        addView(this.hEI);
    }

    public boolean isPrivacy() {
        return (this.hEI == null || this.hEI.getState() != 0) && this.hEI != null && this.hEI.getState() == 1;
    }

    public void bdG() {
        if (this.hEI != null) {
            this.hEI.hideTip();
        }
    }

    public void bFV() {
        if (this.hEH != null) {
            this.hEH.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aN(String str, int i) {
        if ("2".equals(this.hnU)) {
            this.mForumId = str;
            c.a(str, i, new c.a() { // from class: com.baidu.tieba.write.editor.a.4
                @Override // com.baidu.tieba.write.editor.c.a
                public void xt(int i2) {
                    a.this.hEI.setState(i2 != 1 ? 0 : 1);
                }
            });
        }
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
            case 46:
            case 49:
            default:
                return;
            case 19:
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.d.a)) {
                    com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                    if (aVar2 != null && aVar2.brD) {
                        this.hEG.j(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.hEG.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.hEG.hide();
                return;
            case 21:
                this.hEH.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    private void bFW() {
        String string;
        String sharedPrefKeyWithAccount;
        if (this.hEI != null) {
            if ("1".equals(this.hnU)) {
                string = getResources().getString(d.j.privacy_tip_one);
                sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_privacy_tip_one");
            } else if ("2".equals(this.hnU)) {
                string = getResources().getString(d.j.privacy_tip_two);
                sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_privacy_tip_two");
            } else {
                return;
            }
            this.hEI.cm(string, sharedPrefKeyWithAccount);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        if (this.euI) {
            this.euI = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
        bFW();
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axO;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        bdG();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        if (this.hEH != null) {
            this.hEH.onChangeSkinType(i);
        }
        if (this.hEG != null) {
            this.hEG.onChangeSkinType(i);
        }
        if (this.hEI != null) {
            this.hEI.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axN != null) {
            this.axN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axN = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axO = i;
    }
}
