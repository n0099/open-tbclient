package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.e;
import com.baidu.tieba.write.editor.LocationInfoWithDelView;
import com.baidu.tieba.write.editor.a;
/* loaded from: classes3.dex */
public class EditorInfoContainer extends RelativeLayout implements l {
    private EditorTools Tj;
    private int Tk;
    private boolean eOR;
    private String eih;
    private LocationInfoWithDelView hXZ;
    private StateSwitchView hYa;
    private StateSwitchView hYb;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eOR = true;
        int dimension = (int) context.getResources().getDimension(e.C0210e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0210e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.eih = str;
        dg(context);
        dh(context);
        di(context);
    }

    private void dg(Context context) {
        this.hXZ = new LocationInfoWithDelView(context);
        this.hXZ.setId(e.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.hXZ.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bPC() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bPD() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.hXZ.hide();
            }
        });
        addView(this.hXZ, layoutParams);
    }

    private void dh(Context context) {
        this.hYa = new StateSwitchView(context);
        this.hYa.setId(e.g.view_write_thread_add_title);
        this.hYa.setStateString(getResources().getString(e.j.write_add_title), getResources().getString(e.j.write_hide_title));
        this.hYa.setBackgroundId(e.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(e.C0210e.ds16);
        layoutParams.addRule(1, e.g.editor_id_location);
        this.hYa.setLayoutParams(layoutParams);
        this.hYa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EditorInfoContainer.this.hYa.getState() == 0) {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                EditorInfoContainer.this.hYa.asu();
            }
        });
        addView(this.hYa);
    }

    private void di(Context context) {
        this.hYb = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.hYb.setLayoutParams(layoutParams);
        this.hYb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.eih)) {
                        TiebaStatic.log(new am("c12608").y("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.eih)) {
                        TiebaStatic.log(new am("c12608").y("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.hYb.asu();
                if ("2".equals(EditorInfoContainer.this.eih)) {
                    a.bb(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.hYb.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.eih)) {
            this.hYb.setStateString(getResources().getString(e.j.public_to_all), getResources().getString(e.j.public_to_me));
            this.hYb.setBackgroundId(e.f.state_switch_bg);
        } else if ("2".equals(this.eih)) {
            this.hYb.setStateString(getResources().getString(e.j.display_to_home_page), getResources().getString(e.j.display_to_home_page));
            this.hYb.setLeftStateDrawable(e.f.icon_share_home_select_ok, e.f.icon_share_home_select);
            this.hYb.setPadding(this.hYb.getPaddingLeft(), 0, 0, 0);
            this.hYb.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.ds28));
        }
        addView(this.hYb);
    }

    public boolean isPrivacy() {
        return (this.hYb == null || this.hYb.getState() != 0) && this.hYb != null && this.hYb.getState() == 1;
    }

    public void bmw() {
        if (this.hYb != null) {
            this.hYb.hideTip();
        }
    }

    public void bPB() {
        if (this.hYa != null) {
            this.hYa.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void ba(String str, int i) {
        if ("2".equals(this.eih)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0334a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0334a
                public void xy(int i2) {
                    EditorInfoContainer.this.hYb.setState(i2 != 1 ? 0 : 1);
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
                    if (aVar2 != null && aVar2.isShow) {
                        this.hXZ.setState(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.hXZ.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.hXZ.hide();
                return;
            case 21:
                this.hYa.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pR() {
        if (this.eOR) {
            this.eOR = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tk;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        bmw();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        if (this.hYa != null) {
            this.hYa.onChangeSkinType(i);
        }
        if (this.hXZ != null) {
            this.hXZ.onChangeSkinType(i);
        }
        if (this.hYb != null) {
            this.hYb.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Tj != null) {
            this.Tj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Tj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tk = i;
    }
}
