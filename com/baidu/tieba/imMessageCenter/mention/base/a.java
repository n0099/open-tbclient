package com.baidu.tieba.imMessageCenter.mention.base;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import tbclient.AgreeList;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eIH = BdUniqueId.gen();
    public static final BdUniqueId eII = BdUniqueId.gen();
    public static final BdUniqueId eIJ = BdUniqueId.gen();
    public static final BdUniqueId eIK = BdUniqueId.gen();
    public static final BdUniqueId eIL = BdUniqueId.gen();
    private BdUniqueId eIM;
    private boolean eIN;
    private String eIO;
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
        return this.eIM;
    }

    public void a(AgreeList agreeList) {
        if (agreeList != null) {
            this.msgId = agreeList.id.longValue();
            this.replyer = new MetaData();
            this.replyer.parserProtobuf(agreeList.agreeer);
            this.time = agreeList.time.intValue() * 1000;
            if (agreeList.post_info != null) {
                this.post_id = String.valueOf(agreeList.post_info.id);
                if (!w.z(agreeList.post_info.content) && w.d(agreeList.post_info.content, 0) != null && agreeList.post_info.author != null) {
                    String str = agreeList.post_info.author.name_show;
                    if (ap.isEmpty(str)) {
                        str = agreeList.post_info.author.name;
                    }
                    this.subTitle = str + "：" + agreeList.post_info.content.get(0).text;
                }
            }
            bb bbVar = new bb();
            bbVar.a(agreeList.thread_info);
            this.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bbVar);
            this.threadAuthor = bbVar.vj();
            this.fname = bbVar.vp();
            this.thread_id = bbVar.getId();
            this.threadType = bbVar.threadType;
            this.eIO = "c12927";
            if (agreeList.type.intValue() == 3) {
                this.eIM = eIH;
                this.title = TbadkCoreApplication.getInst().getResources().getString(f.j.agree_my_thread);
                return;
            }
            this.eIM = eII;
            this.title = TbadkCoreApplication.getInst().getResources().getString(f.j.agree_my_post);
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
            this.eIN = feedData.getIsFloor();
            this.postFrom = feedData.getPostFrom();
            this.quote_pid = feedData.getQuote_pid();
            this.isNew = feedData.isNew();
            this.threadAuthor = feedData.getThreadAuthor();
            this.originalThreadInfo = new OriginalThreadInfo();
            this.originalThreadInfo.threadId = this.thread_id;
            this.originalThreadInfo.threadType = this.threadType;
            this.originalThreadInfo.showPicUrl = feedData.getThreadImgUrl();
            this.eIO = "c12928";
            if (feedData.getType() == 1) {
                this.originalThreadInfo.postId = feedData.getQuote_pid();
                String str = "";
                if (feedData.getQuote_user() != null) {
                    if (ap.equals(feedData.getQuote_user().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                        str = TbadkCoreApplication.getInst().getString(f.j.me);
                    } else {
                        str = feedData.getQuote_user().getName_show();
                    }
                }
                this.originalThreadInfo.title = TbadkCoreApplication.getInst().getString(f.j.reply_me_original, new Object[]{str, feedData.getQuote_content()});
                if (TextUtils.isGraphic(this.originalThreadInfo.title)) {
                    this.originalThreadInfo.title = this.originalThreadInfo.title.replace("\n", " ");
                }
                if (feedData.getIsFloor()) {
                    this.eIM = eIJ;
                } else {
                    this.eIM = eIK;
                }
            } else {
                this.originalThreadInfo.postId = "0";
                if (feedData.isShareThread() && feedData.getOriginalThreadInfo() != null) {
                    this.originalThreadInfo.title = TbadkCoreApplication.getInst().getString(f.j.share_replyme_original, new Object[]{feedData.getOriginalThreadInfo().showText});
                } else {
                    this.originalThreadInfo.title = feedData.getTitle();
                }
                this.eIM = eIL;
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

    public boolean aPn() {
        return this.eIN;
    }

    public String aPo() {
        return this.quote_pid;
    }

    public boolean isNew() {
        return this.isNew;
    }

    public void ii(boolean z) {
        this.isNew = z;
    }

    public String aPp() {
        return this.eIO;
    }

    public MetaData getThreadAuthor() {
        return this.threadAuthor;
    }
}
