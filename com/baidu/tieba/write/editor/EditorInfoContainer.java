package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.f;
import com.baidu.tieba.write.editor.LocationInfoWithDelView;
import com.baidu.tieba.write.editor.a;
/* loaded from: classes3.dex */
public class EditorInfoContainer extends RelativeLayout implements l {
    private EditorTools Qg;
    private int Qh;
    private String dHS;
    private boolean enW;
    private LocationInfoWithDelView hvC;
    private StateSwitchView hvD;
    private StateSwitchView hvE;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.enW = true;
        int dimension = (int) context.getResources().getDimension(f.e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(f.e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.dHS = str;
        co(context);
        cp(context);
        cq(context);
    }

    private void co(Context context) {
        this.hvC = new LocationInfoWithDelView(context);
        this.hvC.setId(f.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(f.e.ds16);
        this.hvC.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bGx() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bGy() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.hvC.hide();
            }
        });
        addView(this.hvC, layoutParams);
    }

    private void cp(Context context) {
        this.hvD = new StateSwitchView(context);
        this.hvD.setId(f.g.view_write_thread_add_title);
        this.hvD.setStateString(getResources().getString(f.j.write_add_title), getResources().getString(f.j.write_hide_title));
        this.hvD.setBackgroundId(f.C0146f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(f.e.ds16);
        layoutParams.addRule(1, f.g.editor_id_location);
        this.hvD.setLayoutParams(layoutParams);
        this.hvD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EditorInfoContainer.this.hvD.getState() == 0) {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                EditorInfoContainer.this.hvD.akJ();
            }
        });
        addView(this.hvD);
    }

    private void cq(Context context) {
        this.hvE = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.hvE.setLayoutParams(layoutParams);
        this.hvE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.dHS)) {
                        TiebaStatic.log(new an("c12608").r("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.dHS)) {
                        TiebaStatic.log(new an("c12608").r("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.hvE.akJ();
                if ("2".equals(EditorInfoContainer.this.dHS)) {
                    a.aQ(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.hvE.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.dHS)) {
            this.hvE.setStateString(getResources().getString(f.j.public_to_all), getResources().getString(f.j.public_to_me));
            this.hvE.setBackgroundId(f.C0146f.state_switch_bg);
        } else if ("2".equals(this.dHS)) {
            this.hvE.setStateString(getResources().getString(f.j.display_to_home_page), getResources().getString(f.j.display_to_home_page));
            this.hvE.setLeftStateDrawable(f.C0146f.icon_share_home_select_ok, f.C0146f.icon_share_home_select);
            this.hvE.setPadding(this.hvE.getPaddingLeft(), 0, 0, 0);
            this.hvE.setTextSize(0, getResources().getDimensionPixelSize(f.e.ds28));
        }
        addView(this.hvE);
    }

    public boolean isPrivacy() {
        return (this.hvE == null || this.hvE.getState() != 0) && this.hvE != null && this.hvE.getState() == 1;
    }

    public void aoX() {
        if (this.hvE != null) {
            this.hvE.hideTip();
        }
    }

    public void bGw() {
        if (this.hvD != null) {
            this.hvD.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aP(String str, int i) {
        if ("2".equals(this.dHS)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0252a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0252a
                public void vw(int i2) {
                    EditorInfoContainer.this.hvE.setState(i2 != 1 ? 0 : 1);
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
                        this.hvC.setState(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.hvC.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.hvC.hide();
                return;
            case 21:
                this.hvD.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oC() {
        if (this.enW) {
            this.enW = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qh;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        aoX();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        if (this.hvD != null) {
            this.hvD.onChangeSkinType(i);
        }
        if (this.hvC != null) {
            this.hvC.onChangeSkinType(i);
        }
        if (this.hvE != null) {
            this.hvE.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qg != null) {
            this.Qg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qg = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qh = i;
    }
}
