package com.baidu.tieba.imMessageCenter.mention.base;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import tbclient.AgreeList;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ffN = BdUniqueId.gen();
    public static final BdUniqueId ffO = BdUniqueId.gen();
    public static final BdUniqueId ffP = BdUniqueId.gen();
    public static final BdUniqueId ffQ = BdUniqueId.gen();
    public static final BdUniqueId ffR = BdUniqueId.gen();
    private BdUniqueId ffS;
    private boolean ffT;
    private String ffU;
    private String fname;
    private boolean isNew;
    private long msgId;
    private OriginalThreadInfo originalThreadInfo;
    private String postFrom;
    private String post_id;
    private String quote_pid;
    private MetaData replyer = new MetaData();
    private String subTitle;
    private MetaData threadAuthor;
    private int threadType;
    private String thread_id;
    private long time;
    private String title;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return this.ffS;
    }

    public void a(AgreeList agreeList) {
        if (agreeList != null) {
            this.msgId = agreeList.id.longValue();
            this.replyer = new MetaData();
            this.replyer.parserProtobuf(agreeList.agreeer);
            this.time = agreeList.time.intValue() * 1000;
            if (agreeList.post_info != null) {
                this.post_id = String.valueOf(agreeList.post_info.id);
                if (!v.I(agreeList.post_info.content) && v.d(agreeList.post_info.content, 0) != null && agreeList.post_info.author != null) {
                    String str = agreeList.post_info.author.name_show;
                    if (ao.isEmpty(str)) {
                        str = agreeList.post_info.author.name;
                    }
                    this.subTitle = str + "：" + agreeList.post_info.content.get(0).text;
                }
            }
            bb bbVar = new bb();
            bbVar.a(agreeList.thread_info);
            this.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bbVar);
            this.threadAuthor = bbVar.zG();
            this.fname = bbVar.zM();
            this.thread_id = bbVar.getId();
            this.threadType = bbVar.threadType;
            this.ffU = "c12927";
            if (agreeList.type.intValue() == 3) {
                this.ffS = ffN;
                this.title = TbadkCoreApplication.getInst().getResources().getString(e.j.agree_my_thread);
                return;
            }
            this.ffS = ffO;
            this.title = TbadkCoreApplication.getInst().getResources().getString(e.j.agree_my_post);
        }
    }

    public void e(FeedData feedData) {
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
            this.ffT = feedData.getIsFloor();
            this.postFrom = feedData.getPostFrom();
            this.quote_pid = feedData.getQuote_pid();
            this.isNew = feedData.isNew();
            this.threadAuthor = feedData.getThreadAuthor();
            this.originalThreadInfo = new OriginalThreadInfo();
            this.originalThreadInfo.threadId = this.thread_id;
            this.originalThreadInfo.threadType = this.threadType;
            this.originalThreadInfo.showPicUrl = feedData.getThreadImgUrl();
            this.ffU = "c12928";
            if (feedData.getType() == 1) {
                this.originalThreadInfo.postId = feedData.getQuote_pid();
                String str = "";
                if (feedData.getQuote_user() != null) {
                    if (ao.equals(feedData.getQuote_user().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                        str = TbadkCoreApplication.getInst().getString(e.j.me);
                    } else {
                        str = feedData.getQuote_user().getName_show();
                    }
                }
                this.originalThreadInfo.title = TbadkCoreApplication.getInst().getString(e.j.reply_me_original, new Object[]{str, feedData.getQuote_content()});
                if (TextUtils.isGraphic(this.originalThreadInfo.title)) {
                    this.originalThreadInfo.title = this.originalThreadInfo.title.replace("\n", " ");
                }
                if (feedData.getIsFloor()) {
                    this.ffS = ffP;
                } else {
                    this.ffS = ffQ;
                }
            } else {
                this.originalThreadInfo.postId = "0";
                if (feedData.isShareThread() && feedData.getOriginalThreadInfo() != null) {
                    this.originalThreadInfo.title = TbadkCoreApplication.getInst().getString(e.j.share_replyme_original, new Object[]{feedData.getOriginalThreadInfo().showText});
                } else {
                    this.originalThreadInfo.title = feedData.getTitle();
                }
                this.ffS = ffR;
            }
            this.originalThreadInfo.setShowData();
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

    public boolean aWd() {
        return this.ffT;
    }

    public String aWe() {
        return this.quote_pid;
    }

    public boolean isNew() {
        return this.isNew;
    }

    public void jk(boolean z) {
        this.isNew = z;
    }

    public String aWf() {
        return this.ffU;
    }

    public MetaData getThreadAuthor() {
        return this.threadAuthor;
    }
}
