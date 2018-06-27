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
    private EditorTools Qj;
    private int Qk;
    private boolean eki;
    private String hcf;
    private LocationInfoWithDelView huu;
    private StateSwitchView huv;
    private StateSwitchView huw;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eki = true;
        int dimension = (int) context.getResources().getDimension(d.e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.hcf = str;
        co(context);
        cp(context);
        cq(context);
    }

    private void co(Context context) {
        this.huu = new LocationInfoWithDelView(context);
        this.huu.setId(d.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        this.huu.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bHI() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bHJ() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.huu.hide();
            }
        });
        addView(this.huu, layoutParams);
    }

    private void cp(Context context) {
        this.huv = new StateSwitchView(context);
        this.huv.setId(d.g.view_write_thread_add_title);
        this.huv.setStateString(getResources().getString(d.k.write_add_title), getResources().getString(d.k.write_hide_title));
        this.huv.setBackgroundId(d.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        layoutParams.addRule(1, d.g.editor_id_location);
        this.huv.setLayoutParams(layoutParams);
        this.huv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EditorInfoContainer.this.huv.getState() == 0) {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                EditorInfoContainer.this.huv.aki();
            }
        });
        addView(this.huv);
    }

    private void cq(Context context) {
        this.huw = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.huw.setLayoutParams(layoutParams);
        this.huw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.hcf)) {
                        TiebaStatic.log(new an("c12608").r("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.hcf)) {
                        TiebaStatic.log(new an("c12608").r("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.huw.aki();
                if ("2".equals(EditorInfoContainer.this.hcf)) {
                    a.aU(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.huw.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.hcf)) {
            this.huw.setStateString(getResources().getString(d.k.public_to_all), getResources().getString(d.k.public_to_me));
            this.huw.setBackgroundId(d.f.state_switch_bg);
        } else if ("2".equals(this.hcf)) {
            this.huw.setStateString(getResources().getString(d.k.display_to_home_page), getResources().getString(d.k.display_to_home_page));
            this.huw.setLeftStateDrawable(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
            this.huw.setPadding(this.huw.getPaddingLeft(), 0, 0, 0);
            this.huw.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds28));
        }
        addView(this.huw);
    }

    public boolean isPrivacy() {
        return (this.huw == null || this.huw.getState() != 0) && this.huw != null && this.huw.getState() == 1;
    }

    public void aox() {
        if (this.huw != null) {
            this.huw.hideTip();
        }
    }

    public void bHH() {
        if (this.huv != null) {
            this.huv.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aT(String str, int i) {
        if ("2".equals(this.hcf)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0252a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0252a
                public void vx(int i2) {
                    EditorInfoContainer.this.huw.setState(i2 != 1 ? 0 : 1);
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
                    if (aVar2 != null && aVar2.aNI) {
                        this.huu.setState(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.huu.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.huu.hide();
                return;
            case 21:
                this.huv.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oD() {
        if (this.eki) {
            this.eki = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qk;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        aox();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        if (this.huv != null) {
            this.huv.onChangeSkinType(i);
        }
        if (this.huu != null) {
            this.huu.onChangeSkinType(i);
        }
        if (this.huw != null) {
            this.huw.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qj != null) {
            this.Qj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qk = i;
    }
}
