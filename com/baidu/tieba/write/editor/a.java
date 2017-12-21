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
    private i IS;
    private int IT;
    private boolean dHe;
    private String gRp;
    private b hgX;
    private StateSwitchView hgY;
    private StateSwitchView hgZ;
    private String mForumId;
    private String mFrom;

    public a(Context context, String str) {
        this(context, str, null);
    }

    public a(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dHe = true;
        int dimension = (int) context.getResources().getDimension(d.e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.gRp = str;
        ci(context);
        cj(context);
        ck(context);
    }

    private void ci(Context context) {
        this.hgX = new b(context);
        this.hgX.setId(d.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        this.hgX.setLocationClickListener(new b.a() { // from class: com.baidu.tieba.write.editor.a.1
            @Override // com.baidu.tieba.write.editor.b.a
            public void bGK() {
                a.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.b.a
            public void bGL() {
                a.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                a.this.hgX.hide();
            }
        });
        addView(this.hgX, layoutParams);
    }

    private void cj(Context context) {
        this.hgY = new StateSwitchView(context);
        this.hgY.setId(d.g.view_write_thread_add_title);
        this.hgY.cq(getResources().getString(d.j.write_add_title), getResources().getString(d.j.write_hide_title));
        this.hgY.setBackgroundId(d.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        layoutParams.addRule(1, d.g.editor_id_location);
        this.hgY.setLayoutParams(layoutParams);
        this.hgY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hgY.getState() == 0) {
                    a.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    a.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                a.this.hgY.bGM();
            }
        });
        addView(this.hgY);
    }

    private void ck(Context context) {
        this.hgZ = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.hgZ.setLayoutParams(layoutParams);
        this.hgZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(a.this.mFrom)) {
                    if ("1".equals(a.this.gRp)) {
                        TiebaStatic.log(new ak("c12608").r("obj_locate", 6));
                    } else if ("2".equals(a.this.gRp)) {
                        TiebaStatic.log(new ak("c12608").r("obj_locate", 5));
                    }
                }
                a.this.hgZ.bGM();
                if ("2".equals(a.this.gRp)) {
                    c.aM(a.this.mForumId, a.this.hgZ.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.gRp)) {
            this.hgZ.cq(getResources().getString(d.j.public_to_all), getResources().getString(d.j.public_to_me));
            this.hgZ.setBackgroundId(d.f.state_switch_bg);
        } else if ("2".equals(this.gRp)) {
            this.hgZ.cq(getResources().getString(d.j.display_to_home_page), getResources().getString(d.j.display_to_home_page));
            this.hgZ.ch(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
            this.hgZ.setPadding(this.hgZ.getPaddingLeft(), 0, 0, 0);
            this.hgZ.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds28));
        }
        addView(this.hgZ);
    }

    public boolean isPrivacy() {
        return (this.hgZ == null || this.hgZ.getState() != 0) && this.hgZ != null && this.hgZ.getState() == 1;
    }

    public void aWp() {
        if (this.hgZ != null) {
            this.hgZ.hideTip();
        }
    }

    public void bGI() {
        if (this.hgY != null) {
            this.hgY.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aL(String str, int i) {
        if ("2".equals(this.gRp)) {
            this.mForumId = str;
            c.a(str, i, new c.a() { // from class: com.baidu.tieba.write.editor.a.4
                @Override // com.baidu.tieba.write.editor.c.a
                public void vZ(int i2) {
                    a.this.hgZ.setState(i2 != 1 ? 0 : 1);
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
            case d.l.View_hapticFeedbackEnabled /* 46 */:
            case 49:
            default:
                return;
            case 19:
                if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.editortools.d.a)) {
                    com.baidu.tbadk.editortools.d.a aVar2 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                    if (aVar2 != null && aVar2.aDA) {
                        this.hgX.k(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.hgX.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.hgX.hide();
                return;
            case 21:
                this.hgY.setState(1);
                return;
            case d.l.View_transformPivotY /* 54 */:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    private void bGJ() {
        String string;
        String sharedPrefKeyWithAccount;
        if (this.hgZ != null) {
            if ("1".equals(this.gRp)) {
                string = getResources().getString(d.j.privacy_tip_one);
                sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_privacy_tip_one");
            } else if ("2".equals(this.gRp)) {
                string = getResources().getString(d.j.privacy_tip_two);
                sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_privacy_tip_two");
            } else {
                return;
            }
            this.hgZ.cr(string, sharedPrefKeyWithAccount);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lE() {
        if (this.dHe) {
            this.dHe = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
        bGJ();
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IT;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        aWp();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        if (this.hgY != null) {
            this.hgY.onChangeSkinType(i);
        }
        if (this.hgX != null) {
            this.hgX.onChangeSkinType(i);
        }
        if (this.hgZ != null) {
            this.hgZ.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IS != null) {
            this.IS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.IS = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IT = i;
    }
}
