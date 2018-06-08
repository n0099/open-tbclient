package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.write.editor.LocationInfoWithDelView;
import com.baidu.tieba.write.editor.a;
/* loaded from: classes3.dex */
public class EditorInfoContainer extends RelativeLayout implements l {
    private EditorTools Qh;
    private int Qi;
    private boolean egp;
    private String gYa;
    private LocationInfoWithDelView hqk;
    private StateSwitchView hql;
    private StateSwitchView hqm;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.egp = true;
        int dimension = (int) context.getResources().getDimension(d.e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.gYa = str;
        cq(context);
        cr(context);
        cs(context);
    }

    private void cq(Context context) {
        this.hqk = new LocationInfoWithDelView(context);
        this.hqk.setId(d.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        this.hqk.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bHh() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bHi() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.hqk.hide();
            }
        });
        addView(this.hqk, layoutParams);
    }

    private void cr(Context context) {
        this.hql = new StateSwitchView(context);
        this.hql.setId(d.g.view_write_thread_add_title);
        this.hql.setStateString(getResources().getString(d.k.write_add_title), getResources().getString(d.k.write_hide_title));
        this.hql.setBackgroundId(d.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        layoutParams.addRule(1, d.g.editor_id_location);
        this.hql.setLayoutParams(layoutParams);
        this.hql.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EditorInfoContainer.this.hql.getState() == 0) {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                EditorInfoContainer.this.hql.akO();
            }
        });
        addView(this.hql);
    }

    private void cs(Context context) {
        this.hqm = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.hqm.setLayoutParams(layoutParams);
        this.hqm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.gYa)) {
                        TiebaStatic.log(new am("c12608").r("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.gYa)) {
                        TiebaStatic.log(new am("c12608").r("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.hqm.akO();
                if ("2".equals(EditorInfoContainer.this.gYa)) {
                    a.aT(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.hqm.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.gYa)) {
            this.hqm.setStateString(getResources().getString(d.k.public_to_all), getResources().getString(d.k.public_to_me));
            this.hqm.setBackgroundId(d.f.state_switch_bg);
        } else if ("2".equals(this.gYa)) {
            this.hqm.setStateString(getResources().getString(d.k.display_to_home_page), getResources().getString(d.k.display_to_home_page));
            this.hqm.setLeftStateDrawable(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
            this.hqm.setPadding(this.hqm.getPaddingLeft(), 0, 0, 0);
            this.hqm.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds28));
        }
        addView(this.hqm);
    }

    public boolean isPrivacy() {
        return (this.hqm == null || this.hqm.getState() != 0) && this.hqm != null && this.hqm.getState() == 1;
    }

    public void apc() {
        if (this.hqm != null) {
            this.hqm.hideTip();
        }
    }

    public void bHg() {
        if (this.hql != null) {
            this.hql.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aS(String str, int i) {
        if ("2".equals(this.gYa)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0250a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0250a
                public void vo(int i2) {
                    EditorInfoContainer.this.hqm.setState(i2 != 1 ? 0 : 1);
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
                    if (aVar2 != null && aVar2.aMM) {
                        this.hqk.setState(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.hqk.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.hqk.hide();
                return;
            case 21:
                this.hql.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oD() {
        if (this.egp) {
            this.egp = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qi;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        apc();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        if (this.hql != null) {
            this.hql.onChangeSkinType(i);
        }
        if (this.hqk != null) {
            this.hqk.onChangeSkinType(i);
        }
        if (this.hqm != null) {
            this.hqm.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qh != null) {
            this.Qh.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qh = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qi = i;
    }
}
