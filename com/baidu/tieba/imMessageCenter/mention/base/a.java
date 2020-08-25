package com.baidu.tieba.imMessageCenter.mention.base;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import tbclient.AgreeList;
/* loaded from: classes16.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId jGh = BdUniqueId.gen();
    public static final BdUniqueId jGi = BdUniqueId.gen();
    public static final BdUniqueId jGj = BdUniqueId.gen();
    public static final BdUniqueId jGk = BdUniqueId.gen();
    public static final BdUniqueId jGl = BdUniqueId.gen();
    private String fname;
    private boolean isNew;
    private BdUniqueId jGm;
    private boolean jGn;
    private String jGo;
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
        return this.jGm;
    }

    public void a(AgreeList agreeList) {
        if (agreeList != null) {
            this.msgId = agreeList.id.longValue();
            this.replyer = new MetaData();
            this.replyer.parserProtobuf(agreeList.agreeer);
            this.time = agreeList.time.intValue() * 1000;
            if (agreeList.post_info != null) {
                this.post_id = String.valueOf(agreeList.post_info.id);
                if (!y.isEmpty(agreeList.post_info.content) && y.getItem(agreeList.post_info.content, 0) != null && agreeList.post_info.author != null) {
                    String str = agreeList.post_info.author.name_show;
                    if (at.isEmpty(str)) {
                        str = agreeList.post_info.author.name;
                    }
                    this.subTitle = str + "：" + agreeList.post_info.content.get(0).text;
                }
                this.quote_pid = agreeList.post_info.quote_id;
            }
            bw bwVar = new bw();
            bwVar.a(agreeList.thread_info);
            this.originalThreadInfo = OriginalThreadInfo.s(bwVar);
            this.threadAuthor = bwVar.beE();
            this.fname = bwVar.beI();
            this.thread_id = bwVar.getId();
            this.threadType = bwVar.threadType;
            this.isBjh = bwVar.bdo();
            this.mBaijiahao = bwVar.getBaijiahaoData();
            this.jGo = "c12927";
            if (agreeList.type.intValue() == 3) {
                this.jGm = jGh;
                this.title = TbadkCoreApplication.getInst().getResources().getString(R.string.agree_my_thread);
                if (this.isBjh) {
                    this.title = TbadkCoreApplication.getInst().getResources().getString(R.string.agree_my_dynamic);
                    return;
                }
                return;
            }
            this.jGm = jGi;
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
            this.jGn = feedData.getIsFloor();
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
            this.originalThreadInfo.dZf = this.isBjh;
            this.originalThreadInfo.oriUgcInfo = this.mBaijiahao;
            this.jGo = "c12928";
            if (feedData.getType() == 1) {
                this.originalThreadInfo.postId = feedData.getQuote_pid();
                String str = "";
                if (feedData.getQuote_user() != null) {
                    if (at.equals(feedData.getQuote_user().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
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
                    this.jGm = jGj;
                } else {
                    this.jGm = jGk;
                }
            } else {
                this.originalThreadInfo.postId = "0";
                if (feedData.isShareThread() && feedData.getOriginalThreadInfo() != null) {
                    this.originalThreadInfo.title = TbadkCoreApplication.getInst().getString(R.string.share_replyme_original, new Object[]{feedData.getOriginalThreadInfo().showText});
                } else {
                    this.originalThreadInfo.title = feedData.getTitle();
                }
                this.jGm = jGl;
            }
            this.originalThreadInfo.bdi();
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

    public boolean cJY() {
        return this.jGn;
    }

    public String cJZ() {
        return this.quote_pid;
    }

    public boolean isNew() {
        return this.isNew;
    }

    public void rn(boolean z) {
        this.isNew = z;
    }

    public String cKa() {
        return this.jGo;
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
