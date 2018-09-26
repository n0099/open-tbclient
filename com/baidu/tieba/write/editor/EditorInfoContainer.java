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
    private EditorTools SG;
    private int SH;
    private String dOX;
    private boolean evq;
    private LocationInfoWithDelView hDx;
    private StateSwitchView hDy;
    private StateSwitchView hDz;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evq = true;
        int dimension = (int) context.getResources().getDimension(e.C0141e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0141e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.dOX = str;
        cV(context);
        cW(context);
        cX(context);
    }

    private void cV(Context context) {
        this.hDx = new LocationInfoWithDelView(context);
        this.hDx.setId(e.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(e.C0141e.ds16);
        this.hDx.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bJn() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bJo() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.hDx.hide();
            }
        });
        addView(this.hDx, layoutParams);
    }

    private void cW(Context context) {
        this.hDy = new StateSwitchView(context);
        this.hDy.setId(e.g.view_write_thread_add_title);
        this.hDy.setStateString(getResources().getString(e.j.write_add_title), getResources().getString(e.j.write_hide_title));
        this.hDy.setBackgroundId(e.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(e.C0141e.ds16);
        layoutParams.addRule(1, e.g.editor_id_location);
        this.hDy.setLayoutParams(layoutParams);
        this.hDy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EditorInfoContainer.this.hDy.getState() == 0) {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                EditorInfoContainer.this.hDy.amu();
            }
        });
        addView(this.hDy);
    }

    private void cX(Context context) {
        this.hDz = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.hDz.setLayoutParams(layoutParams);
        this.hDz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.dOX)) {
                        TiebaStatic.log(new am("c12608").w("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.dOX)) {
                        TiebaStatic.log(new am("c12608").w("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.hDz.amu();
                if ("2".equals(EditorInfoContainer.this.dOX)) {
                    a.aV(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.hDz.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.dOX)) {
            this.hDz.setStateString(getResources().getString(e.j.public_to_all), getResources().getString(e.j.public_to_me));
            this.hDz.setBackgroundId(e.f.state_switch_bg);
        } else if ("2".equals(this.dOX)) {
            this.hDz.setStateString(getResources().getString(e.j.display_to_home_page), getResources().getString(e.j.display_to_home_page));
            this.hDz.setLeftStateDrawable(e.f.icon_share_home_select_ok, e.f.icon_share_home_select);
            this.hDz.setPadding(this.hDz.getPaddingLeft(), 0, 0, 0);
            this.hDz.setTextSize(0, getResources().getDimensionPixelSize(e.C0141e.ds28));
        }
        addView(this.hDz);
    }

    public boolean isPrivacy() {
        return (this.hDz == null || this.hDz.getState() != 0) && this.hDz != null && this.hDz.getState() == 1;
    }

    public void aqM() {
        if (this.hDz != null) {
            this.hDz.hideTip();
        }
    }

    public void bJm() {
        if (this.hDy != null) {
            this.hDy.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aU(String str, int i) {
        if ("2".equals(this.dOX)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0258a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0258a
                public void vW(int i2) {
                    EditorInfoContainer.this.hDz.setState(i2 != 1 ? 0 : 1);
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
                        this.hDx.setState(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.hDx.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.hDx.hide();
                return;
            case 21:
                this.hDy.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pI() {
        if (this.evq) {
            this.evq = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SH;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        aqM();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        if (this.hDy != null) {
            this.hDy.onChangeSkinType(i);
        }
        if (this.hDx != null) {
            this.hDx.onChangeSkinType(i);
        }
        if (this.hDz != null) {
            this.hDz.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.SG != null) {
            this.SG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.SG = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SH = i;
    }
}
