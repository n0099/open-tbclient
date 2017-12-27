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
    private i axO;
    private int axP;
    private boolean etk;
    private b hOY;
    private StateSwitchView hOZ;
    private StateSwitchView hPa;
    private String hyr;
    private String mForumId;
    private String mFrom;

    public a(Context context, String str) {
        this(context, str, null);
    }

    public a(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.etk = true;
        int dimension = (int) context.getResources().getDimension(d.e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.hyr = str;
        ct(context);
        cu(context);
        cv(context);
    }

    private void ct(Context context) {
        this.hOY = new b(context);
        this.hOY.setId(d.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        this.hOY.setLocationClickListener(new b.a() { // from class: com.baidu.tieba.write.editor.a.1
            @Override // com.baidu.tieba.write.editor.b.a
            public void bMx() {
                a.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.b.a
            public void bMy() {
                a.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                a.this.hOY.hide();
            }
        });
        addView(this.hOY, layoutParams);
    }

    private void cu(Context context) {
        this.hOZ = new StateSwitchView(context);
        this.hOZ.setId(d.g.view_write_thread_add_title);
        this.hOZ.cr(getResources().getString(d.j.write_add_title), getResources().getString(d.j.write_hide_title));
        this.hOZ.setBackgroundId(d.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        layoutParams.addRule(1, d.g.editor_id_location);
        this.hOZ.setLayoutParams(layoutParams);
        this.hOZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hOZ.getState() == 0) {
                    a.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    a.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                a.this.hOZ.bMz();
            }
        });
        addView(this.hOZ);
    }

    private void cv(Context context) {
        this.hPa = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.hPa.setLayoutParams(layoutParams);
        this.hPa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(a.this.mFrom)) {
                    if ("1".equals(a.this.hyr)) {
                        TiebaStatic.log(new ak("c12608").s("obj_locate", 6));
                    } else if ("2".equals(a.this.hyr)) {
                        TiebaStatic.log(new ak("c12608").s("obj_locate", 5));
                    }
                }
                a.this.hPa.bMz();
                if ("2".equals(a.this.hyr)) {
                    c.aM(a.this.mForumId, a.this.hPa.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.hyr)) {
            this.hPa.cr(getResources().getString(d.j.public_to_all), getResources().getString(d.j.public_to_me));
            this.hPa.setBackgroundId(d.f.state_switch_bg);
        } else if ("2".equals(this.hyr)) {
            this.hPa.cr(getResources().getString(d.j.display_to_home_page), getResources().getString(d.j.display_to_home_page));
            this.hPa.de(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
            this.hPa.setPadding(this.hPa.getPaddingLeft(), 0, 0, 0);
            this.hPa.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds28));
        }
        addView(this.hPa);
    }

    public boolean isPrivacy() {
        return (this.hPa == null || this.hPa.getState() != 0) && this.hPa != null && this.hPa.getState() == 1;
    }

    public void bdC() {
        if (this.hPa != null) {
            this.hPa.hideTip();
        }
    }

    public void bMv() {
        if (this.hOZ != null) {
            this.hOZ.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aL(String str, int i) {
        if ("2".equals(this.hyr)) {
            this.mForumId = str;
            c.a(str, i, new c.a() { // from class: com.baidu.tieba.write.editor.a.4
                @Override // com.baidu.tieba.write.editor.c.a
                public void yQ(int i2) {
                    a.this.hPa.setState(i2 != 1 ? 0 : 1);
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
                    if (aVar2 != null && aVar2.bru) {
                        this.hOY.j(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.hOY.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.hOY.hide();
                return;
            case 21:
                this.hOZ.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    private void bMw() {
        String string;
        String sharedPrefKeyWithAccount;
        if (this.hPa != null) {
            if ("1".equals(this.hyr)) {
                string = getResources().getString(d.j.privacy_tip_one);
                sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_privacy_tip_one");
            } else if ("2".equals(this.hyr)) {
                string = getResources().getString(d.j.privacy_tip_two);
                sharedPrefKeyWithAccount = com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("key_show_privacy_tip_two");
            } else {
                return;
            }
            this.hPa.cs(string, sharedPrefKeyWithAccount);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        if (this.etk) {
            this.etk = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
        bMw();
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axP;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        bdC();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        if (this.hOZ != null) {
            this.hOZ.onChangeSkinType(i);
        }
        if (this.hOY != null) {
            this.hOY.onChangeSkinType(i);
        }
        if (this.hPa != null) {
            this.hPa.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axO != null) {
            this.axO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axO = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axP = i;
    }
}
