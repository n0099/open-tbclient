package com.baidu.tieba.imMessageCenter.mention.base;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import tbclient.AgreeList;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eES = BdUniqueId.gen();
    public static final BdUniqueId eET = BdUniqueId.gen();
    public static final BdUniqueId eEU = BdUniqueId.gen();
    public static final BdUniqueId eEV = BdUniqueId.gen();
    public static final BdUniqueId eEW = BdUniqueId.gen();
    private BdUniqueId eEX;
    private boolean eEY;
    private String eEZ;
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
        return this.eEX;
    }

    public void a(AgreeList agreeList) {
        if (agreeList != null) {
            this.msgId = agreeList.id.longValue();
            this.replyer = new MetaData();
            this.replyer.parserProtobuf(agreeList.agreeer);
            this.time = agreeList.time.intValue() * 1000;
            if (agreeList.post_info != null) {
                this.post_id = String.valueOf(agreeList.post_info.id);
                if (!w.A(agreeList.post_info.content) && w.d(agreeList.post_info.content, 0) != null && agreeList.post_info.author != null) {
                    String str = agreeList.post_info.author.name_show;
                    if (ap.isEmpty(str)) {
                        str = agreeList.post_info.author.name;
                    }
                    this.subTitle = str + "：" + agreeList.post_info.content.get(0).text;
                }
            }
            bc bcVar = new bc();
            bcVar.a(agreeList.thread_info);
            this.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bcVar);
            this.threadAuthor = bcVar.vw();
            this.fname = bcVar.vB();
            this.thread_id = bcVar.getId();
            this.threadType = bcVar.threadType;
            this.eEZ = "c12927";
            if (agreeList.type.intValue() == 3) {
                this.eEX = eES;
                this.title = TbadkCoreApplication.getInst().getResources().getString(d.k.agree_my_thread);
                return;
            }
            this.eEX = eET;
            this.title = TbadkCoreApplication.getInst().getResources().getString(d.k.agree_my_post);
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
            this.eEY = feedData.getIsFloor();
            this.postFrom = feedData.getPostFrom();
            this.quote_pid = feedData.getQuote_pid();
            this.isNew = feedData.isNew();
            this.threadAuthor = feedData.getThreadAuthor();
            this.originalThreadInfo = new OriginalThreadInfo();
            this.originalThreadInfo.threadId = this.thread_id;
            this.originalThreadInfo.threadType = this.threadType;
            this.originalThreadInfo.showPicUrl = feedData.getThreadImgUrl();
            this.eEZ = "c12928";
            if (feedData.getType() == 1) {
                this.originalThreadInfo.postId = feedData.getQuote_pid();
                String str = "";
                if (feedData.getQuote_user() != null) {
                    if (ap.equals(feedData.getQuote_user().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                        str = TbadkCoreApplication.getInst().getString(d.k.me);
                    } else {
                        str = feedData.getQuote_user().getName_show();
                    }
                }
                this.originalThreadInfo.title = TbadkCoreApplication.getInst().getString(d.k.reply_me_original, new Object[]{str, feedData.getQuote_content()});
                if (TextUtils.isGraphic(this.originalThreadInfo.title)) {
                    this.originalThreadInfo.title = this.originalThreadInfo.title.replace("\n", " ");
                }
                if (feedData.getIsFloor()) {
                    this.eEX = eEU;
                } else {
                    this.eEX = eEV;
                }
            } else {
                this.originalThreadInfo.postId = "0";
                if (feedData.isShareThread() && feedData.getOriginalThreadInfo() != null) {
                    this.originalThreadInfo.title = TbadkCoreApplication.getInst().getString(d.k.share_replyme_original, new Object[]{feedData.getOriginalThreadInfo().showText});
                } else {
                    this.originalThreadInfo.title = feedData.getTitle();
                }
                this.eEX = eEW;
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

    public boolean aOq() {
        return this.eEY;
    }

    public String aOr() {
        return this.quote_pid;
    }

    public boolean isNew() {
        return this.isNew;
    }

    /* renamed from: if  reason: not valid java name */
    public void m16if(boolean z) {
        this.isNew = z;
    }

    public String aOs() {
        return this.eEZ;
    }

    public MetaData getThreadAuthor() {
        return this.threadAuthor;
    }
}
