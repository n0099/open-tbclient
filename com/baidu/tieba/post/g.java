package com.baidu.tieba.post;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class g extends BaseAdapter {
    private BdUniqueId agC;
    private TbPageContext<BaseFragmentActivity> iVp;
    private PersonPostModel mBf;
    private PersonPostModel.a mLS;
    private final PersonPostModel.a mLT = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.mBf = personPostModel;
                Iterator<n> it = g.this.mBf.postList.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.mBf != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.mBf.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.mLS != null) {
                g.this.mLS.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0850a mLU = new a.InterfaceC0850a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0850a
        public void dY(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.iVp.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.iVp.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer || id == R.id.reply_count) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.iVp.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.iVp.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;
    private String mzU;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.iVp = tbPageContext;
        this.mUid = str;
        this.agC = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.mLS = aVar;
    }

    public void xt(boolean z) {
        if (this.mBf == null) {
            this.mBf = new PersonPostModel(this.iVp, this.agC, null, true, PersonPostModel.FROM_PERSON_POST);
            this.mBf.setUniqueId(this.agC);
        }
        this.mBf.fetchPost(this.iVp, this.mLT, z, this.mUid, false, true, false, null);
    }

    public void cFE() {
        if (this.mBf != null) {
            this.mBf.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mBf == null || this.mBf.postList == null) {
            return 0;
        }
        return this.mBf.postList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_post_item_reply, viewGroup, false);
            aVar = new a(view, this.iVp);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.mDp.setVisibility(0);
        } else {
            aVar.mDp.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList Ht(int i) {
        return (PersonPostModel.PostInfoList) this.mBf.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList Ht = Ht(i);
        if (this.mzU == null) {
            this.mzU = Ht.user_portrait;
        }
        aVar.a(Ht, false, this.mzU);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = Ht.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (Ht.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!Ht.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = Ht.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(Ht.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(Ht.thread_id), String.valueOf(Ht.content[i2].post_id), String.valueOf(Ht.content[i2].post_type), au.getFormatTime(Ht.content[i2].create_time * 1000) + (Ht.content[i2].is_author_view == 1 ? " " + viewGroup.getContext().getString(R.string.not_open_read) : ""), String.valueOf(Ht.thread_type)});
            }
        }
        aVar.mLW.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(Ht.title).find()) {
            aVar.mDi.setText(Ht.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.mDi.setText(Ht.title);
        }
        if (Ht.originalThreadInfo != null && !StringUtils.isNull(Ht.originalThreadInfo.showText)) {
            aVar.mDi.setText("分享：" + Ht.originalThreadInfo.showText);
        }
        aVar.mDi.setTag(new String[]{String.valueOf(Ht.thread_id), null, null, String.valueOf(Ht.thread_type)});
        if (Ht.thread_type == 33) {
            aVar.mDi.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.mDi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        ap.setBackgroundResource(aVar.mDi, R.drawable.person_post_line);
        ap.setViewTextColor(aVar.mDi, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.mDi.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.mLU);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes8.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View ixF;
        private View ixG;
        public TextView mDi;
        public ReplyLinearLayout mLW;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.mLW = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.mDi = (TextView) view.findViewById(R.id.original_post_title);
            this.ixF = view.findViewById(R.id.reply_top_line);
            this.ixG = view.findViewById(R.id.reply_bottom_line);
            this.mDi.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            ap.setBackgroundResource(this.mDi, R.color.CAM_X0205);
            ap.setViewTextColor(this.mDi, R.color.CAM_X0105, 1);
            ap.setBackgroundResource(this.ixF, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ixG, R.color.CAM_X0204);
        }
    }
}
