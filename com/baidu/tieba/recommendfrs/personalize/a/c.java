package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.a.o;
import com.baidu.tieba.card.ae;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<o, a> {
    private ae dqg;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: az */
    public a a(ViewGroup viewGroup) {
        this.dqg = new ae(this.mPageContext);
        return new a(this.dqg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, o oVar, a aVar) {
        if (aVar == null || aVar.dqh == null) {
            return null;
        }
        if (oVar != null) {
            oVar.fc(i + 1);
            oVar.b(b(oVar));
            oVar.c(c(oVar));
            oVar.d(e(oVar));
            oVar.e(d(oVar));
        }
        aVar.dqh.a(oVar);
        return aVar.getView();
    }

    private av b(o oVar) {
        if (oVar == null || oVar.Iv() == null) {
            return null;
        }
        return new av("c10732").aa(ImageViewerConfig.FORUM_ID, String.valueOf(oVar.Iv().ss())).aa("tid", String.valueOf(oVar.Iv().getTid())).aa("obj_param1", oVar.getWeight()).aa("obj_source", oVar.getSource()).r("obj_locate", oVar.Is()).r("obj_type", oVar.IG());
    }

    private av c(o oVar) {
        if (oVar == null || oVar.Iv() == null) {
            return null;
        }
        return new av("c10707").aa(ImageViewerConfig.FORUM_ID, String.valueOf(oVar.Iv().ss())).aa("tid", String.valueOf(oVar.Iv().getTid())).aa("obj_param1", oVar.getWeight()).aa("obj_source", oVar.getSource()).r("obj_locate", oVar.Is()).r("obj_type", oVar.IG());
    }

    private av d(o oVar) {
        if (oVar == null || oVar.Iv() == null) {
            return null;
        }
        return new av("c10733").aa(ImageViewerConfig.FORUM_ID, String.valueOf(oVar.Iv().ss())).aa("tid", String.valueOf(oVar.Iv().getTid())).aa("obj_param1", oVar.getWeight()).aa("obj_source", oVar.getSource()).r("obj_locate", oVar.Is()).r("obj_type", oVar.IG());
    }

    private av e(o oVar) {
        if (oVar == null || oVar.Iv() == null) {
            return null;
        }
        return new av("c10706").aa(ImageViewerConfig.FORUM_ID, String.valueOf(oVar.Iv().ss())).aa("tid", String.valueOf(oVar.Iv().getTid())).aa("obj_param1", oVar.getWeight()).aa("obj_source", oVar.getSource()).r("obj_locate", oVar.Is()).r("obj_type", oVar.IG());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public ae dqh;

        public a(ae aeVar) {
            super(aeVar.getView());
            this.dqh = aeVar;
        }
    }
}
