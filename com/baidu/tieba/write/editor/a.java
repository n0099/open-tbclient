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
    private i axH;
    private int axI;
    private boolean ezu;
    private b hGJ;
    private StateSwitchView hGK;
    private StateSwitchView hGL;
    private String hpO;
    private String mForumId;
    private String mFrom;

    public a(Context context, String str) {
        this(context, str, null);
    }

    public a(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ezu = true;
        int dimension = (int) context.getResources().getDimension(d.e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.hpO = str;
        cp(context);
        cq(context);
        cr(context);
    }

    private void cp(Context context) {
        this.hGJ = new b(context);
        this.hGJ.setId(d.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        this.hGJ.setLocationClickListener(new b.a() { // from class: com.baidu.tieba.write.editor.a.1
            @Override // com.baidu.tieba.write.editor.b.a
            public void bGR() {
                a.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.b.a
            public void bGS() {
                a.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                a.this.hGJ.hide();
            }
        });
        addView(this.hGJ, layoutParams);
    }

    private void cq(Context context) {
        this.hGK = new StateSwitchView(context);
        this.hGK.setId(d.g.view_write_thread_add_title);
        this.hGK.cm(getResources().getString(d.j.write_add_title), getResources().getString(d.j.write_hide_title));
        this.hGK.setBackgroundId(d.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        layoutParams.addRule(1, d.g.editor_id_location);
        this.hGK.setLayoutParams(layoutParams);
        this.hGK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hGK.getState() == 0) {
                    a.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    a.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                a.this.hGK.bGT();
            }
        });
        addView(this.hGK);
    }

    private void cr(Context context) {
        this.hGL = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.hGL.setLayoutParams(layoutParams);
        this.hGL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(a.this.mFrom)) {
                    if ("1".equals(a.this.hpO)) {
                        TiebaStatic.log(new ak("c12608").s("obj_locate", 6));
                    } else if ("2".equals(a.this.hpO)) {
                        TiebaStatic.log(new ak("c12608").s("obj_locate", 5));
                    }
                }
                a.this.hGL.bGT();
                if ("2".equals(a.this.hpO)) {
                    c.aP(a.this.mForumId, a.this.hGL.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.hpO)) {
            this.hGL.cm(getResources().getString(d.j.public_to_all), getResources().getString(d.j.public_to_me));
            this.hGL.setBackgroundId(d.f.state_switch_bg);
        } else if ("2".equals(this.hpO)) {
            this.hGL.cm(getResources().getString(d.j.display_to_home_page), getResources().getString(d.j.display_to_home_page));
            this.hGL.cS(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
            this.hGL.setPadding(this.hGL.getPaddingLeft(), 0, 0, 0);
            this.hGL.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds28));
        }
        addView(this.hGL);
    }

    public boolean isPrivacy() {
        return (this.hGL == null || this.hGL.getState() != 0) && this.hGL != null && this.hGL.getState() == 1;
    }

    public void bfm() {
        if (this.hGL != null) {
            this.hGL.hideTip();
        }
    }

    public void bGP() {
        if (this.hGK != null) {
            this.hGK.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aO(String str, int i) {
        if ("2".equals(this.hpO)) {
            this.mForumId = str;
            c.a(str, i, new c.a() { // from class: com.baidu.tieba.write.editor.a.4
                @Override // com.baidu.tieba.write.editor.c.a
                public void xt(int i2) {
                    a.this.hGL.setState(i2 != 1 ? 0 : 1);
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
                    if (aVar2 != null && aVar2.btQ) {
                        this.hGJ.j(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.hGJ.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.hGJ.hide();
                return;
            case 21:
                this.hGK.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    private void bGQ() {
        String string;
        String sharedPrefKeyWithAccount;
        if (this.hGL != null) {
            if ("1".equals(this.hpO)) {
                string = getResources().getString(d.j.privacy_tip_one);
                sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_privacy_tip_one");
            } else if ("2".equals(this.hpO)) {
                string = getResources().getString(d.j.privacy_tip_two);
                sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_privacy_tip_two");
            } else {
                return;
            }
            this.hGL.cn(string, sharedPrefKeyWithAccount);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        if (this.ezu) {
            this.ezu = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
        bGQ();
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axI;
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
        if (this.hGK != null) {
            this.hGK.onChangeSkinType(i);
        }
        if (this.hGJ != null) {
            this.hGJ.onChangeSkinType(i);
        }
        if (this.hGL != null) {
            this.hGL.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axH != null) {
            this.axH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axH = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axI = i;
    }
}
