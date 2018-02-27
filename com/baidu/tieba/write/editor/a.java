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
    private i axG;
    private int axH;
    private boolean eze;
    private b hGl;
    private StateSwitchView hGm;
    private StateSwitchView hGn;
    private String hpq;
    private String mForumId;
    private String mFrom;

    public a(Context context, String str) {
        this(context, str, null);
    }

    public a(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eze = true;
        int dimension = (int) context.getResources().getDimension(d.e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.hpq = str;
        cp(context);
        cq(context);
        cr(context);
    }

    private void cp(Context context) {
        this.hGl = new b(context);
        this.hGl.setId(d.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        this.hGl.setLocationClickListener(new b.a() { // from class: com.baidu.tieba.write.editor.a.1
            @Override // com.baidu.tieba.write.editor.b.a
            public void bGM() {
                a.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.b.a
            public void bGN() {
                a.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                a.this.hGl.hide();
            }
        });
        addView(this.hGl, layoutParams);
    }

    private void cq(Context context) {
        this.hGm = new StateSwitchView(context);
        this.hGm.setId(d.g.view_write_thread_add_title);
        this.hGm.cm(getResources().getString(d.j.write_add_title), getResources().getString(d.j.write_hide_title));
        this.hGm.setBackgroundId(d.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        layoutParams.addRule(1, d.g.editor_id_location);
        this.hGm.setLayoutParams(layoutParams);
        this.hGm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hGm.getState() == 0) {
                    a.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    a.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                a.this.hGm.bGO();
            }
        });
        addView(this.hGm);
    }

    private void cr(Context context) {
        this.hGn = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.hGn.setLayoutParams(layoutParams);
        this.hGn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(a.this.mFrom)) {
                    if ("1".equals(a.this.hpq)) {
                        TiebaStatic.log(new ak("c12608").s("obj_locate", 6));
                    } else if ("2".equals(a.this.hpq)) {
                        TiebaStatic.log(new ak("c12608").s("obj_locate", 5));
                    }
                }
                a.this.hGn.bGO();
                if ("2".equals(a.this.hpq)) {
                    c.aP(a.this.mForumId, a.this.hGn.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.hpq)) {
            this.hGn.cm(getResources().getString(d.j.public_to_all), getResources().getString(d.j.public_to_me));
            this.hGn.setBackgroundId(d.f.state_switch_bg);
        } else if ("2".equals(this.hpq)) {
            this.hGn.cm(getResources().getString(d.j.display_to_home_page), getResources().getString(d.j.display_to_home_page));
            this.hGn.cS(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
            this.hGn.setPadding(this.hGn.getPaddingLeft(), 0, 0, 0);
            this.hGn.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds28));
        }
        addView(this.hGn);
    }

    public boolean isPrivacy() {
        return (this.hGn == null || this.hGn.getState() != 0) && this.hGn != null && this.hGn.getState() == 1;
    }

    public void bfl() {
        if (this.hGn != null) {
            this.hGn.hideTip();
        }
    }

    public void bGK() {
        if (this.hGm != null) {
            this.hGm.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aO(String str, int i) {
        if ("2".equals(this.hpq)) {
            this.mForumId = str;
            c.a(str, i, new c.a() { // from class: com.baidu.tieba.write.editor.a.4
                @Override // com.baidu.tieba.write.editor.c.a
                public void xt(int i2) {
                    a.this.hGn.setState(i2 != 1 ? 0 : 1);
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
                    if (aVar2 != null && aVar2.btN) {
                        this.hGl.j(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.hGl.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.hGl.hide();
                return;
            case 21:
                this.hGm.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    private void bGL() {
        String string;
        String sharedPrefKeyWithAccount;
        if (this.hGn != null) {
            if ("1".equals(this.hpq)) {
                string = getResources().getString(d.j.privacy_tip_one);
                sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_privacy_tip_one");
            } else if ("2".equals(this.hpq)) {
                string = getResources().getString(d.j.privacy_tip_two);
                sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_privacy_tip_two");
            } else {
                return;
            }
            this.hGn.cn(string, sharedPrefKeyWithAccount);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        if (this.eze) {
            this.eze = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
        bGL();
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axH;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        bfl();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        if (this.hGm != null) {
            this.hGm.onChangeSkinType(i);
        }
        if (this.hGl != null) {
            this.hGl.onChangeSkinType(i);
        }
        if (this.hGn != null) {
            this.hGn.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axG != null) {
            this.axG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axG = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axH = i;
    }
}
