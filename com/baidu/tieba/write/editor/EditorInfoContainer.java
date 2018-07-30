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
import com.baidu.tieba.d;
import com.baidu.tieba.write.editor.LocationInfoWithDelView;
import com.baidu.tieba.write.editor.a;
/* loaded from: classes3.dex */
public class EditorInfoContainer extends RelativeLayout implements l {
    private EditorTools Qg;
    private int Qh;
    private String dHW;
    private boolean eoa;
    private LocationInfoWithDelView hvA;
    private StateSwitchView hvB;
    private StateSwitchView hvC;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eoa = true;
        int dimension = (int) context.getResources().getDimension(d.e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.dHW = str;
        cp(context);
        cq(context);
        cr(context);
    }

    private void cp(Context context) {
        this.hvA = new LocationInfoWithDelView(context);
        this.hvA.setId(d.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        this.hvA.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bGt() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bGu() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.hvA.hide();
            }
        });
        addView(this.hvA, layoutParams);
    }

    private void cq(Context context) {
        this.hvB = new StateSwitchView(context);
        this.hvB.setId(d.g.view_write_thread_add_title);
        this.hvB.setStateString(getResources().getString(d.j.write_add_title), getResources().getString(d.j.write_hide_title));
        this.hvB.setBackgroundId(d.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        layoutParams.addRule(1, d.g.editor_id_location);
        this.hvB.setLayoutParams(layoutParams);
        this.hvB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EditorInfoContainer.this.hvB.getState() == 0) {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                EditorInfoContainer.this.hvB.akH();
            }
        });
        addView(this.hvB);
    }

    private void cr(Context context) {
        this.hvC = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.hvC.setLayoutParams(layoutParams);
        this.hvC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.dHW)) {
                        TiebaStatic.log(new an("c12608").r("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.dHW)) {
                        TiebaStatic.log(new an("c12608").r("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.hvC.akH();
                if ("2".equals(EditorInfoContainer.this.dHW)) {
                    a.aQ(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.hvC.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.dHW)) {
            this.hvC.setStateString(getResources().getString(d.j.public_to_all), getResources().getString(d.j.public_to_me));
            this.hvC.setBackgroundId(d.f.state_switch_bg);
        } else if ("2".equals(this.dHW)) {
            this.hvC.setStateString(getResources().getString(d.j.display_to_home_page), getResources().getString(d.j.display_to_home_page));
            this.hvC.setLeftStateDrawable(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
            this.hvC.setPadding(this.hvC.getPaddingLeft(), 0, 0, 0);
            this.hvC.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds28));
        }
        addView(this.hvC);
    }

    public boolean isPrivacy() {
        return (this.hvC == null || this.hvC.getState() != 0) && this.hvC != null && this.hvC.getState() == 1;
    }

    public void aoX() {
        if (this.hvC != null) {
            this.hvC.hideTip();
        }
    }

    public void bGs() {
        if (this.hvB != null) {
            this.hvB.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aP(String str, int i) {
        if ("2".equals(this.dHW)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0252a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0252a
                public void vw(int i2) {
                    EditorInfoContainer.this.hvC.setState(i2 != 1 ? 0 : 1);
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
                        this.hvA.setState(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.hvA.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.hvA.hide();
                return;
            case 21:
                this.hvB.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oF() {
        if (this.eoa) {
            this.eoa = false;
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
        if (this.hvB != null) {
            this.hvB.onChangeSkinType(i);
        }
        if (this.hvA != null) {
            this.hvA.onChangeSkinType(i);
        }
        if (this.hvC != null) {
            this.hvC.onChangeSkinType(i);
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
