package com.baidu.tieba.write.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.write.editor.LocationInfoWithDelView;
import com.baidu.tieba.write.editor.a;
/* loaded from: classes3.dex */
public class EditorInfoContainer extends RelativeLayout implements l {
    private EditorTools TA;
    private int TB;
    private String fOd;
    private boolean fwo;
    private LocationInfoWithDelView jHF;
    private StateSwitchView jHG;
    private StateSwitchView jHH;
    private String mForumId;
    private String mFrom;

    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
    }

    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fwo = true;
        int dimension = (int) context.getResources().getDimension(R.dimen.ds14);
        setLayoutParams(new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds90)));
        setPadding(dimension, 0, dimension, 0);
        setGravity(16);
        this.fOd = str;
        er(context);
        es(context);
        et(context);
    }

    private void er(Context context) {
        this.jHF = new LocationInfoWithDelView(context);
        this.jHF.setId(R.id.editor_id_location);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.ds16);
        this.jHF.setLocationClickListener(new LocationInfoWithDelView.a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.1
            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void cxA() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(18, -1, null));
            }

            @Override // com.baidu.tieba.write.editor.LocationInfoWithDelView.a
            public void cxB() {
                EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(20, -1, null));
                EditorInfoContainer.this.jHF.hide();
            }
        });
        addView(this.jHF, layoutParams);
    }

    private void es(Context context) {
        this.jHG = new StateSwitchView(context);
        this.jHG.setId(R.id.view_write_thread_add_title);
        this.jHG.setStateString(getResources().getString(R.string.write_add_title), getResources().getString(R.string.write_hide_title));
        this.jHG.setBackgroundId(R.drawable.state_switch_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.ds16);
        layoutParams.addRule(1, R.id.editor_id_location);
        this.jHG.setLayoutParams(layoutParams);
        this.jHG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EditorInfoContainer.this.jHG.getState() == 0) {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(45, -1, null));
                } else {
                    EditorInfoContainer.this.b(new com.baidu.tbadk.editortools.a(53, -1, null));
                }
                EditorInfoContainer.this.jHG.aFu();
            }
        });
        addView(this.jHG);
    }

    private void et(Context context) {
        this.jHH = new StateSwitchView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        this.jHH.setLayoutParams(layoutParams);
        this.jHH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if ("from_share_write".equals(EditorInfoContainer.this.mFrom)) {
                    if ("1".equals(EditorInfoContainer.this.fOd)) {
                        TiebaStatic.log(new am("c12608").P("obj_locate", 6));
                    } else if ("2".equals(EditorInfoContainer.this.fOd)) {
                        TiebaStatic.log(new am("c12608").P("obj_locate", 5));
                    }
                }
                EditorInfoContainer.this.jHH.aFu();
                if ("2".equals(EditorInfoContainer.this.fOd)) {
                    a.bt(EditorInfoContainer.this.mForumId, EditorInfoContainer.this.jHH.getState() == 0 ? 0 : 1);
                }
            }
        });
        if ("1".equals(this.fOd)) {
            this.jHH.setStateString(getResources().getString(R.string.public_to_all), getResources().getString(R.string.public_to_me));
            this.jHH.setBackgroundId(R.drawable.state_switch_bg);
        } else if ("2".equals(this.fOd)) {
            this.jHH.setStateString(getResources().getString(R.string.display_to_home_page), getResources().getString(R.string.display_to_home_page));
            this.jHH.setLeftStateDrawable(R.drawable.icon_share_home_select_ok, R.drawable.icon_share_home_select);
            this.jHH.setPadding(this.jHH.getPaddingLeft(), 0, 0, 0);
            this.jHH.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds28));
        }
        addView(this.jHH);
    }

    public boolean isPrivacy() {
        return (this.jHH == null || this.jHH.getState() != 0) && this.jHH != null && this.jHH.getState() == 1;
    }

    public void bed() {
        if (this.jHH != null) {
            this.jHH.hideTip();
        }
    }

    public void cxz() {
        if (this.jHG != null) {
            this.jHG.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void bs(String str, int i) {
        if ("2".equals(this.fOd)) {
            this.mForumId = str;
            a.a(str, i, new a.InterfaceC0427a() { // from class: com.baidu.tieba.write.editor.EditorInfoContainer.4
                @Override // com.baidu.tieba.write.editor.a.InterfaceC0427a
                public void Cs(int i2) {
                    EditorInfoContainer.this.jHH.setState(i2 != 1 ? 0 : 1);
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
                        this.jHF.setState(aVar2.state, aVar2.addr);
                        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                            if (!StringUtils.isNull(aVar2.addr)) {
                                setVisibility(0);
                                return;
                            } else {
                                setVisibility(8);
                                return;
                            }
                        }
                        return;
                    }
                    this.jHF.hide();
                    if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            case 20:
                this.jHF.hide();
                if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    setVisibility(8);
                    return;
                }
                return;
            case 21:
                this.jHG.setState(1);
                return;
            case 54:
                b(new com.baidu.tbadk.editortools.a(55, -1, Boolean.valueOf(isPrivacy())));
                return;
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pO() {
        if (this.fwo) {
            this.fwo = false;
            b(new com.baidu.tbadk.editortools.a(18, -1, Config.TRACE_VISIT_FIRST));
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TB;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        bed();
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        if (this.jHG != null) {
            this.jHG.onChangeSkinType(i);
        }
        if (this.jHF != null) {
            this.jHF.onChangeSkinType(i);
        }
        if (this.jHH != null) {
            this.jHH.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TA != null) {
            this.TA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TA = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TB = i;
    }
}
