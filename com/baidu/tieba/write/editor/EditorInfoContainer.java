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
    private EditorTools Ta;
    private int Tb;
    private String dYg;
    private boolean eEy;
    private LocationInfoWithDelView hMv;
    private StateSwitchView hMw;
    private StateSwitchView hMx;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eEy = true;
        int dimension = (int) context.getResources().getDimension(e.C0200e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0200e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.dYg = str;
        dc(context);
        dd(context);
        de(context);
    }

    private void dc(Context context) {
        this.hMv = new LocationInfoWithDelView(context);
        this.hMv.setId(e.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(e.C0200e.ds16);
        this.hMv.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bLY() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bLZ() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.hMv.hide();
            }
        });
        addView(this.hMv, layoutParams);
    }

    private void dd(Context context) {
        this.hMw = new StateSwitchView(context);
        this.hMw.setId(e.g.view_write_thread_add_title);
        this.hMw.setStateString(getResources().getString(e.j.write_add_title), getResources().getString(e.j.write_hide_title));
        this.hMw.setBackgroundId(e.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(e.C0200e.ds16);
        layoutParams.addRule(1, e.g.editor_id_location);
        this.hMw.setLayoutParams(layoutParams);
        this.hMw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EditorInfoContainer.this.hMw.getState() == 0) {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                EditorInfoContainer.this.hMw.apv();
            }
        });
        addView(this.hMw);
    }

    private void de(Context context) {
        this.hMx = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.hMx.setLayoutParams(layoutParams);
        this.hMx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.dYg)) {
                        TiebaStatic.log(new am("c12608").x("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.dYg)) {
                        TiebaStatic.log(new am("c12608").x("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.hMx.apv();
                if ("2".equals(EditorInfoContainer.this.dYg)) {
                    a.aZ(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.hMx.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.dYg)) {
            this.hMx.setStateString(getResources().getString(e.j.public_to_all), getResources().getString(e.j.public_to_me));
            this.hMx.setBackgroundId(e.f.state_switch_bg);
        } else if ("2".equals(this.dYg)) {
            this.hMx.setStateString(getResources().getString(e.j.display_to_home_page), getResources().getString(e.j.display_to_home_page));
            this.hMx.setLeftStateDrawable(e.f.icon_share_home_select_ok, e.f.icon_share_home_select);
            this.hMx.setPadding(this.hMx.getPaddingLeft(), 0, 0, 0);
            this.hMx.setTextSize(0, getResources().getDimensionPixelSize(e.C0200e.ds28));
        }
        addView(this.hMx);
    }

    public boolean isPrivacy() {
        return (this.hMx == null || this.hMx.getState() != 0) && this.hMx != null && this.hMx.getState() == 1;
    }

    public void atH() {
        if (this.hMx != null) {
            this.hMx.hideTip();
        }
    }

    public void bLX() {
        if (this.hMw != null) {
            this.hMw.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aY(String str, int i) {
        if ("2".equals(this.dYg)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0321a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0321a
                public void wM(int i2) {
                    EditorInfoContainer.this.hMx.setState(i2 != 1 ? 0 : 1);
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
                        this.hMv.setState(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.hMv.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.hMv.hide();
                return;
            case 21:
                this.hMw.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pO() {
        if (this.eEy) {
            this.eEy = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tb;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        atH();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        if (this.hMw != null) {
            this.hMw.onChangeSkinType(i);
        }
        if (this.hMv != null) {
            this.hMv.onChangeSkinType(i);
        }
        if (this.hMx != null) {
            this.hMx.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ta != null) {
            this.Ta.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tb = i;
    }
}
