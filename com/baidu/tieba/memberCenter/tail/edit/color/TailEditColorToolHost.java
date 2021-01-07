package com.baidu.tieba.memberCenter.tail.edit.color;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class TailEditColorToolHost extends NoPressedLinearLayout implements n {
    private EditorTools acZ;
    private int ada;
    private View.OnClickListener foD;
    private c loU;
    private a loX;
    private e loY;

    public TailEditColorToolHost(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext.getPageActivity());
        this.ada = 0;
        this.foD = new View.OnClickListener() { // from class: com.baidu.tieba.memberCenter.tail.edit.color.TailEditColorToolHost.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b bVar = (b) view.getTag();
                if (bVar != null) {
                    TailEditColorToolHost.this.loU.uv(bVar.getColor());
                    TailEditColorToolHost.this.loX.notifyDataSetChanged();
                    TailEditColorToolHost.this.acZ.b(new com.baidu.tbadk.editortools.a(26, -1, bVar.getColor()));
                }
            }
        };
        e(tbPageContext, str);
    }

    private void e(TbPageContext<?> tbPageContext, String str) {
        LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tail_edit_color, (ViewGroup) this, true);
        this.loY = new e(this);
        this.loU = new c(tbPageContext);
        this.loU.uv(str);
        this.loX = new a(tbPageContext, this.loU, this.foD);
        this.loY.a(this.loX);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acZ = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acZ != null) {
            this.acZ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.ada = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.ada;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void rV() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
    }
}
