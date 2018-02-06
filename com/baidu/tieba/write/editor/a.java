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
    private i axP;
    private int axQ;
    private boolean ezq;
    private StateSwitchView hGA;
    private b hGy;
    private StateSwitchView hGz;
    private String hpD;
    private String mForumId;
    private String mFrom;

    public a(Context context, String str) {
        this(context, str, null);
    }

    public a(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ezq = true;
        int dimension = (int) context.getResources().getDimension(d.e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.hpD = str;
        cp(context);
        cq(context);
        cr(context);
    }

    private void cp(Context context) {
        this.hGy = new b(context);
        this.hGy.setId(d.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        this.hGy.setLocationClickListener(new b.a() { // from class: com.baidu.tieba.write.editor.a.1
            @Override // com.baidu.tieba.write.editor.b.a
            public void bGN() {
                a.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.b.a
            public void bGO() {
                a.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                a.this.hGy.hide();
            }
        });
        addView(this.hGy, layoutParams);
    }

    private void cq(Context context) {
        this.hGz = new StateSwitchView(context);
        this.hGz.setId(d.g.view_write_thread_add_title);
        this.hGz.cm(getResources().getString(d.j.write_add_title), getResources().getString(d.j.write_hide_title));
        this.hGz.setBackgroundId(d.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        layoutParams.addRule(1, d.g.editor_id_location);
        this.hGz.setLayoutParams(layoutParams);
        this.hGz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hGz.getState() == 0) {
                    a.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    a.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                a.this.hGz.bGP();
            }
        });
        addView(this.hGz);
    }

    private void cr(Context context) {
        this.hGA = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.hGA.setLayoutParams(layoutParams);
        this.hGA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(a.this.mFrom)) {
                    if ("1".equals(a.this.hpD)) {
                        TiebaStatic.log(new ak("c12608").s("obj_locate", 6));
                    } else if ("2".equals(a.this.hpD)) {
                        TiebaStatic.log(new ak("c12608").s("obj_locate", 5));
                    }
                }
                a.this.hGA.bGP();
                if ("2".equals(a.this.hpD)) {
                    c.aP(a.this.mForumId, a.this.hGA.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.hpD)) {
            this.hGA.cm(getResources().getString(d.j.public_to_all), getResources().getString(d.j.public_to_me));
            this.hGA.setBackgroundId(d.f.state_switch_bg);
        } else if ("2".equals(this.hpD)) {
            this.hGA.cm(getResources().getString(d.j.display_to_home_page), getResources().getString(d.j.display_to_home_page));
            this.hGA.cS(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
            this.hGA.setPadding(this.hGA.getPaddingLeft(), 0, 0, 0);
            this.hGA.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds28));
        }
        addView(this.hGA);
    }

    public boolean isPrivacy() {
        return (this.hGA == null || this.hGA.getState() != 0) && this.hGA != null && this.hGA.getState() == 1;
    }

    public void bfm() {
        if (this.hGA != null) {
            this.hGA.hideTip();
        }
    }

    public void bGL() {
        if (this.hGz != null) {
            this.hGz.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aO(String str, int i) {
        if ("2".equals(this.hpD)) {
            this.mForumId = str;
            c.a(str, i, new c.a() { // from class: com.baidu.tieba.write.editor.a.4
                @Override // com.baidu.tieba.write.editor.c.a
                public void xs(int i2) {
                    a.this.hGA.setState(i2 != 1 ? 0 : 1);
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
                    if (aVar2 != null && aVar2.bua) {
                        this.hGy.j(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.hGy.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.hGy.hide();
                return;
            case 21:
                this.hGz.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    private void bGM() {
        String string;
        String sharedPrefKeyWithAccount;
        if (this.hGA != null) {
            if ("1".equals(this.hpD)) {
                string = getResources().getString(d.j.privacy_tip_one);
                sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_privacy_tip_one");
            } else if ("2".equals(this.hpD)) {
                string = getResources().getString(d.j.privacy_tip_two);
                sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_privacy_tip_two");
            } else {
                return;
            }
            this.hGA.cn(string, sharedPrefKeyWithAccount);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        if (this.ezq) {
            this.ezq = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
        bGM();
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axQ;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        bfm();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        if (this.hGz != null) {
            this.hGz.onChangeSkinType(i);
        }
        if (this.hGy != null) {
            this.hGy.onChangeSkinType(i);
        }
        if (this.hGA != null) {
            this.hGA.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axP != null) {
            this.axP.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axP = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axQ = i;
    }
}
