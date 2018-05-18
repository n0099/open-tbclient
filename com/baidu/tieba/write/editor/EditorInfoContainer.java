package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.write.editor.LocationInfoWithDelView;
import com.baidu.tieba.write.editor.a;
/* loaded from: classes3.dex */
public class EditorInfoContainer extends RelativeLayout implements l {
    private EditorTools JO;
    private int JP;
    private boolean dVc;
    private String gMy;
    private LocationInfoWithDelView hep;
    private StateSwitchView heq;
    private StateSwitchView her;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dVc = true;
        int dimension = (int) context.getResources().getDimension(d.e.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.gMy = str;
        cf(context);
        cg(context);
        ch(context);
    }

    private void cf(Context context) {
        this.hep = new LocationInfoWithDelView(context);
        this.hep.setId(d.g.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        this.hep.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bCb() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void bCc() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.hep.hide();
            }
        });
        addView(this.hep, layoutParams);
    }

    private void cg(Context context) {
        this.heq = new StateSwitchView(context);
        this.heq.setId(d.g.view_write_thread_add_title);
        this.heq.setStateString(getResources().getString(d.k.write_add_title), getResources().getString(d.k.write_hide_title));
        this.heq.setBackgroundId(d.f.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.e.ds16);
        layoutParams.addRule(1, d.g.editor_id_location);
        this.heq.setLayoutParams(layoutParams);
        this.heq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (EditorInfoContainer.this.heq.getState() == 0) {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                EditorInfoContainer.this.heq.bCd();
            }
        });
        addView(this.heq);
    }

    private void ch(Context context) {
        this.her = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.her.setLayoutParams(layoutParams);
        this.her.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.gMy)) {
                        TiebaStatic.log(new al("c12608").r("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.gMy)) {
                        TiebaStatic.log(new al("c12608").r("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.her.bCd();
                if ("2".equals(EditorInfoContainer.this.gMy)) {
                    a.aQ(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.her.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.gMy)) {
            this.her.setStateString(getResources().getString(d.k.public_to_all), getResources().getString(d.k.public_to_me));
            this.her.setBackgroundId(d.f.state_switch_bg);
        } else if ("2".equals(this.gMy)) {
            this.her.setStateString(getResources().getString(d.k.display_to_home_page), getResources().getString(d.k.display_to_home_page));
            this.her.setLeftStateDrawable(d.f.icon_share_home_select_ok, d.f.icon_share_home_select);
            this.her.setPadding(this.her.getPaddingLeft(), 0, 0, 0);
            this.her.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds28));
        }
        addView(this.her);
    }

    public boolean isPrivacy() {
        return (this.her == null || this.her.getState() != 0) && this.her != null && this.her.getState() == 1;
    }

    public void akW() {
        if (this.her != null) {
            this.her.hideTip();
        }
    }

    public void bCa() {
        if (this.heq != null) {
            this.heq.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void aP(String str, int i) {
        if ("2".equals(this.gMy)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0233a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0233a
                public void uW(int i2) {
                    EditorInfoContainer.this.her.setState(i2 != 1 ? 0 : 1);
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
                    if (aVar2 != null && aVar2.aEq) {
                        this.hep.setState(aVar2.state, aVar2.addr);
                        return;
                    } else {
                        this.hep.hide();
                        return;
                    }
                }
                return;
            case 20:
                this.hep.hide();
                return;
            case 21:
                this.heq.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void lM() {
        if (this.dVc) {
            this.dVc = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, "first"));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.JP;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        akW();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        if (this.heq != null) {
            this.heq.onChangeSkinType(i);
        }
        if (this.hep != null) {
            this.hep.onChangeSkinType(i);
        }
        if (this.her != null) {
            this.her.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JO != null) {
            this.JO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.JO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.JP = i;
    }
}
