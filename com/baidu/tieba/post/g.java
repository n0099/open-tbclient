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
import com.baidu.adp.widget.ListView.q;
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
/* loaded from: classes24.dex */
public class g extends BaseAdapter {
    private BdUniqueId ajD;
    private TbPageContext<BaseFragmentActivity> iHO;
    private PersonPostModel.a mBL;
    private final PersonPostModel.a mBM = new PersonPostModel.a() { // from class: com.baidu.tieba.post.g.1
        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.a
        public void b(PersonPostModel personPostModel, boolean z) {
            if (z) {
                g.this.mrg = personPostModel;
                Iterator<q> it = g.this.mrg.postList.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                        it.remove();
                    }
                }
            } else if (g.this.mrg != null) {
                for (int i = 0; i < personPostModel.postList.size(); i++) {
                    if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                        g.this.mrg.postList.add(personPostModel.postList.get(i));
                    }
                }
            }
            if (g.this.mBL != null) {
                g.this.mBL.b(personPostModel, z);
            }
            g.this.notifyDataSetChanged();
        }
    };
    private final a.InterfaceC0846a mBN = new a.InterfaceC0846a() { // from class: com.baidu.tieba.post.g.2
        @Override // com.baidu.tieba.post.a.InterfaceC0846a
        public void dQ(View view) {
            String[] strArr;
            int id = view.getId();
            if (id == R.id.portrait) {
                ((BaseFragmentActivity) g.this.iHO.getOrignalPage()).finish();
            } else if (id == R.id.username) {
                ((BaseFragmentActivity) g.this.iHO.getOrignalPage()).finish();
            } else if ((id == R.id.item_header || id == R.id.original_post_title || id == R.id.item_footer || id == R.id.reply_count) && (strArr = (String[]) view.getTag()) != null) {
                if ("0".equals(strArr[2]) || strArr[1] == null) {
                    PbActivityConfig createNormalCfg = new PbActivityConfig(g.this.iHO.getPageActivity()).createNormalCfg(strArr[0], strArr[1], "person_page");
                    createNormalCfg.setStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                    return;
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(g.this.iHO.getPageActivity()).createSubPbActivityConfig(strArr[0], strArr[1], "person_post_reply", false);
                createSubPbActivityConfig.setKeyPageStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
        }
    };
    private final String mUid;
    private String mpW;
    private PersonPostModel mrg;

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        this.iHO = tbPageContext;
        this.mUid = str;
        this.ajD = bdUniqueId;
    }

    public void a(PersonPostModel.a aVar) {
        this.mBL = aVar;
    }

    public void xe(boolean z) {
        if (this.mrg == null) {
            this.mrg = new PersonPostModel(this.iHO, this.ajD, null, true, PersonPostModel.FROM_PERSON_POST);
            this.mrg.setUniqueId(this.ajD);
        }
        this.mrg.fetchPost(this.iHO, this.mBM, z, this.mUid, false, true, false, null);
    }

    public void cFg() {
        if (this.mrg != null) {
            this.mrg.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mrg == null || this.mrg.postList == null) {
            return 0;
        }
        return this.mrg.postList.size();
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
            aVar = new a(view, this.iHO);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.mto.setVisibility(0);
        } else {
            aVar.mto.setVisibility(8);
        }
        a(i, aVar, viewGroup);
        return view;
    }

    public PersonPostModel.PostInfoList IO(int i) {
        return (PersonPostModel.PostInfoList) this.mrg.postList.get(i);
    }

    private void a(int i, a aVar, ViewGroup viewGroup) {
        PersonPostModel.PostInfoList IO = IO(i);
        if (this.mpW == null) {
            this.mpW = IO.user_portrait;
        }
        aVar.a(IO, false, this.mpW);
        ArrayList<String[]> arrayList = new ArrayList<>();
        int length = IO.content.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (IO.content[i2].post_content.length != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                if (!IO.content[i2].post_content[0].text.startsWith("回复 ")) {
                    stringBuffer.append("回复：");
                }
                int length2 = IO.content[i2].post_content.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    stringBuffer.append(IO.content[i2].post_content[i3].text);
                }
                arrayList.add(new String[]{stringBuffer.toString(), String.valueOf(IO.thread_id), String.valueOf(IO.content[i2].post_id), String.valueOf(IO.content[i2].post_type), au.getFormatTime(IO.content[i2].create_time * 1000), String.valueOf(IO.thread_type)});
            }
        }
        aVar.mBP.setContent(arrayList);
        if (Pattern.compile("^回复：").matcher(IO.title).find()) {
            aVar.mth.setText(IO.title.replaceFirst("回复：", "原贴："));
        } else {
            aVar.mth.setText(IO.title);
        }
        if (IO.originalThreadInfo != null && !StringUtils.isNull(IO.originalThreadInfo.showText)) {
            aVar.mth.setText("分享：" + IO.originalThreadInfo.showText);
        }
        aVar.mth.setTag(new String[]{String.valueOf(IO.thread_id), null, null, String.valueOf(IO.thread_type)});
        if (IO.thread_type == 33) {
            aVar.mth.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            aVar.mth.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        ap.setBackgroundResource(aVar.mth, R.drawable.person_post_line);
        ap.setViewTextColor(aVar.mth, R.color.common_color_10039, 1);
        int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.ds20);
        aVar.mth.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        aVar.a(this.mBN);
        aVar.changeSkin(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes24.dex */
    public static class a extends com.baidu.tieba.post.a {
        private View ijX;
        private View ijY;
        public ReplyLinearLayout mBP;
        public TextView mth;

        public a(View view, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view, tbPageContext);
            this.mBP = (ReplyLinearLayout) view.findViewById(R.id.content_container);
            this.mth = (TextView) view.findViewById(R.id.original_post_title);
            this.ijX = view.findViewById(R.id.reply_top_line);
            this.ijY = view.findViewById(R.id.reply_bottom_line);
            this.mth.setOnClickListener(this);
        }

        @Override // com.baidu.tieba.post.a
        public void changeSkin(int i) {
            super.changeSkin(i);
            ap.setBackgroundResource(this.mth, R.color.CAM_X0205);
            ap.setViewTextColor(this.mth, R.color.CAM_X0105, 1);
            ap.setBackgroundResource(this.ijX, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ijY, R.color.CAM_X0204);
        }
    }
}
