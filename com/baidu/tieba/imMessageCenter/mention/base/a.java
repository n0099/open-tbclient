package com.baidu.tieba.imMessageCenter.mention.base;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import tbclient.AgreeList;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jiB = BdUniqueId.gen();
    public static final BdUniqueId jiC = BdUniqueId.gen();
    public static final BdUniqueId jiD = BdUniqueId.gen();
    public static final BdUniqueId jiE = BdUniqueId.gen();
    public static final BdUniqueId jiF = BdUniqueId.gen();
    private String fname;
    private boolean isNew;
    private BdUniqueId jiG;
    private boolean jiH;
    private String jiI;
    private BaijiahaoData mBaijiahao;
    private long msgId;
    private OriginalThreadInfo originalThreadInfo;
    private String postFrom;
    private String post_id;
    private String quote_pid;
    private String subTitle;
    private MetaData threadAuthor;
    private int threadType;
    private String thread_id;
    private long time;
    private String title;
    private MetaData replyer = new MetaData();
    private boolean isBjh = false;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return this.jiG;
    }

    public void a(AgreeList agreeList) {
        if (agreeList != null) {
            this.msgId = agreeList.id.longValue();
            this.replyer = new MetaData();
            this.replyer.parserProtobuf(agreeList.agreeer);
            this.time = agreeList.time.intValue() * 1000;
            if (agreeList.post_info != null) {
                this.post_id = String.valueOf(agreeList.post_info.id);
                if (!w.isEmpty(agreeList.post_info.content) && w.getItem(agreeList.post_info.content, 0) != null && agreeList.post_info.author != null) {
                    String str = agreeList.post_info.author.name_show;
                    if (ar.isEmpty(str)) {
                        str = agreeList.post_info.author.name;
                    }
                    this.subTitle = str + "：" + agreeList.post_info.content.get(0).text;
                }
                this.quote_pid = agreeList.post_info.quote_id;
            }
            bu buVar = new bu();
            buVar.a(agreeList.thread_info);
            this.originalThreadInfo = OriginalThreadInfo.r(buVar);
            this.threadAuthor = buVar.aSp();
            this.fname = buVar.aSt();
            this.thread_id = buVar.getId();
            this.threadType = buVar.threadType;
            this.isBjh = buVar.aQZ();
            this.mBaijiahao = buVar.getBaijiahaoData();
            this.jiI = "c12927";
            if (agreeList.type.intValue() == 3) {
                this.jiG = jiB;
                this.title = TbadkCoreApplication.getInst().getResources().getString(R.string.agree_my_thread);
                if (this.isBjh) {
                    this.title = TbadkCoreApplication.getInst().getResources().getString(R.string.agree_my_dynamic);
                    return;
                }
                return;
            }
            this.jiG = jiC;
            this.title = TbadkCoreApplication.getInst().getResources().getString(R.string.agree_my_post);
        }
    }

    public void f(FeedData feedData) {
        if (feedData != null) {
            this.replyer = feedData.getReplyer();
            this.time = feedData.getTime();
            this.post_id = feedData.getPost_id();
            if (!feedData.isHideForumName()) {
                this.fname = feedData.getFname();
            }
            this.thread_id = feedData.getThread_id();
            this.threadType = feedData.getThread_Type();
            this.title = feedData.getContent();
            this.jiH = feedData.getIsFloor();
            this.postFrom = feedData.getPostFrom();
            this.quote_pid = feedData.getQuote_pid();
            this.isNew = feedData.isNew();
            this.threadAuthor = feedData.getThreadAuthor();
            this.isBjh = feedData.isBjh();
            this.mBaijiahao = feedData.getBaijiahaoData();
            this.originalThreadInfo = new OriginalThreadInfo();
            this.originalThreadInfo.threadId = this.thread_id;
            this.originalThreadInfo.threadType = this.threadType;
            this.originalThreadInfo.showPicUrl = feedData.getThreadImgUrl();
            this.originalThreadInfo.dJA = this.isBjh;
            this.originalThreadInfo.oriUgcInfo = this.mBaijiahao;
            this.jiI = "c12928";
            if (feedData.getType() == 1) {
                this.originalThreadInfo.postId = feedData.getQuote_pid();
                String str = "";
                if (feedData.getQuote_user() != null) {
                    if (ar.equals(feedData.getQuote_user().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                        str = TbadkCoreApplication.getInst().getString(R.string.me);
                    } else {
                        str = feedData.getQuote_user().getName_show();
                    }
                }
                this.originalThreadInfo.title = TbadkCoreApplication.getInst().getString(R.string.reply_me_original, new Object[]{str, feedData.getQuote_content()});
                if (TextUtils.isGraphic(this.originalThreadInfo.title)) {
                    this.originalThreadInfo.title = this.originalThreadInfo.title.replace("\n", " ");
                }
                if (feedData.getIsFloor()) {
                    this.jiG = jiD;
                } else {
                    this.jiG = jiE;
                }
            } else {
                this.originalThreadInfo.postId = "0";
                if (feedData.isShareThread() && feedData.getOriginalThreadInfo() != null) {
                    this.originalThreadInfo.title = TbadkCoreApplication.getInst().getString(R.string.share_replyme_original, new Object[]{feedData.getOriginalThreadInfo().showText});
                } else {
                    this.originalThreadInfo.title = feedData.getTitle();
                }
                this.jiG = jiF;
            }
            this.originalThreadInfo.aQT();
        }
    }

    public MetaData getReplyer() {
        return this.replyer;
    }

    public String getPostFrom() {
        return this.postFrom;
    }

    public long getTime() {
        return this.time;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public OriginalThreadInfo getOriginalThreadInfo() {
        return this.originalThreadInfo;
    }

    public String getFname() {
        return this.fname;
    }

    public String getThread_id() {
        return this.thread_id;
    }

    public String getPost_id() {
        return this.post_id;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public boolean cvk() {
        return this.jiH;
    }

    public String cvl() {
        return this.quote_pid;
    }

    public boolean isNew() {
        return this.isNew;
    }

    public void qa(boolean z) {
        this.isNew = z;
    }

    public String cvm() {
        return this.jiI;
    }

    public MetaData getThreadAuthor() {
        return this.threadAuthor;
    }

    public boolean isBjh() {
        return this.isBjh;
    }

    public BaijiahaoData getBaijiahaoData() {
        return this.mBaijiahao;
    }
}
