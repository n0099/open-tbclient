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
    private i axQ;
    private int axR;
    private boolean evd;
    private b hFa;
    private StateSwitchView hFb;
    private StateSwitchView hFc;
    private String hoo;
    private String mForumId;
    private String mFrom;

    public a(Context context, String str) {
        this(context, str, null);
    }

    public a(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evd = true;
        int dimension = (int) context.getResources().getDimension(d.e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.hoo = str;
        cm(context);
        cn(context);
        co(context);
    }

    private void cm(Context context) {
        this.hFa = new b(context);
        this.hFa.setId(d.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        this.hFa.setLocationClickListener(new b.a() { // from class: com.baidu.tieba.write.editor.a.1
            @Override // com.baidu.tieba.write.editor.b.a
            public void bFZ() {
                a.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.b.a
            public void bGa() {
                a.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                a.this.hFa.hide();
            }
        });
        addView(this.hFa, layoutParams);
    }

    private void cn(Context context) {
        this.hFb = new StateSwitchView(context);
        this.hFb.setId(d.g.view_write_thread_add_title);
        this.hFb.ck(getResources().getString(d.j.write_add_title), getResources().getString(d.j.write_hide_title));
        this.hFb.setBackgroundId(d.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        layoutParams.addRule(1, d.g.editor_id_location);
        this.hFb.setLayoutParams(layoutParams);
        this.hFb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hFb.getState() == 0) {
                    a.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    a.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                a.this.hFb.bGb();
            }
        });
        addView(this.hFb);
    }

    private void co(Context context) {
        this.hFc = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.hFc.setLayoutParams(layoutParams);
        this.hFc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(a.this.mFrom)) {
                    if ("1".equals(a.this.hoo)) {
                        TiebaStatic.log(new ak("c12608").s("obj_locate", 6));
                    } else if ("2".equals(a.this.hoo)) {
                        TiebaStatic.log(new ak("c12608").s("obj_locate", 5));
                    }
                }
                a.this.hFc.bGb();
                if ("2".equals(a.this.hoo)) {
                    c.aO(a.this.mForumId, a.this.hFc.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.hoo)) {
            this.hFc.ck(getResources().getString(d.j.public_to_all), getResources().getString(d.j.public_to_me));
            this.hFc.setBackgroundId(d.f.state_switch_bg);
        } else if ("2".equals(this.hoo)) {
            this.hFc.ck(getResources().getString(d.j.display_to_home_page), getResources().getString(d.j.display_to_home_page));
            this.hFc.cX(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
            this.hFc.setPadding(this.hFc.getPaddingLeft(), 0, 0, 0);
            this.hFc.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds28));
        }
        addView(this.hFc);
    }

    public boolean isPrivacy() {
        return (this.hFc == null || this.hFc.getState() != 0) && this.hFc != null && this.hFc.getState() == 1;
    }

    public void bdL() {
        if (this.hFc != null) {
            this.hFc.hideTip();
        }
    }

    public void bFX() {
        if (this.hFb != null) {
            this.hFb.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aN(String str, int i) {
        if ("2".equals(this.hoo)) {
            this.mForumId = str;
            c.a(str, i, new c.a() { // from class: com.baidu.tieba.write.editor.a.4
                @Override // com.baidu.tieba.write.editor.c.a
                public void xt(int i2) {
                    a.this.hFc.setState(i2 != 1 ? 0 : 1);
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
                    if (aVar2 != null && aVar2.brM) {
                        this.hFa.j(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.hFa.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.hFa.hide();
                return;
            case 21:
                this.hFb.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    private void bFY() {
        String string;
        String sharedPrefKeyWithAccount;
        if (this.hFc != null) {
            if ("1".equals(this.hoo)) {
                string = getResources().getString(d.j.privacy_tip_one);
                sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_privacy_tip_one");
            } else if ("2".equals(this.hoo)) {
                string = getResources().getString(d.j.privacy_tip_two);
                sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_privacy_tip_two");
            } else {
                return;
            }
            this.hFc.cl(string, sharedPrefKeyWithAccount);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void ti() {
        if (this.evd) {
            this.evd = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
        bFY();
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axR;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        bdL();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        if (this.hFb != null) {
            this.hFb.onChangeSkinType(i);
        }
        if (this.hFa != null) {
            this.hFa.onChangeSkinType(i);
        }
        if (this.hFc != null) {
            this.hFc.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axQ != null) {
            this.axQ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axQ = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axR = i;
    }
}
