package com.baidu.tieba.imMessageCenter.mention.base;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import tbclient.AgreeList;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eTW = BdUniqueId.gen();
    public static final BdUniqueId eTX = BdUniqueId.gen();
    public static final BdUniqueId eTY = BdUniqueId.gen();
    public static final BdUniqueId eTZ = BdUniqueId.gen();
    public static final BdUniqueId eUa = BdUniqueId.gen();
    private BdUniqueId eUb;
    private boolean eUc;
    private String eUd;
    private String fname;
    private boolean isNew;
    private long msgId;
    private OriginalThreadInfo originalThreadInfo;
    private String postFrom;
    private String post_id;
    private String quote_pid;
    private MetaData replyer = new MetaData();
    private String subTitle;
    private int threadType;
    private String thread_id;
    private long time;
    private String title;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return this.eUb;
    }

    public void a(AgreeList agreeList) {
        if (agreeList != null) {
            this.msgId = agreeList.id.longValue();
            this.replyer = new MetaData();
            this.replyer.parserProtobuf(agreeList.agreeer);
            this.time = agreeList.time.intValue() * 1000;
            if (agreeList.post_info != null) {
                this.post_id = String.valueOf(agreeList.post_info.id);
                if (!v.E(agreeList.post_info.content) && v.f(agreeList.post_info.content, 0) != null && agreeList.post_info.author != null) {
                    String str = agreeList.post_info.author.name_show;
                    if (am.isEmpty(str)) {
                        str = agreeList.post_info.author.name;
                    }
                    this.subTitle = str + "：" + agreeList.post_info.content.get(0).text;
                }
            }
            bd bdVar = new bd();
            bdVar.a(agreeList.thread_info);
            this.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(bdVar);
            this.fname = bdVar.zt();
            this.thread_id = bdVar.getId();
            this.threadType = bdVar.threadType;
            this.eUd = "c12927";
            if (agreeList.type.intValue() == 3) {
                this.eUb = eTW;
                this.title = TbadkCoreApplication.getInst().getResources().getString(d.j.agree_my_thread);
                return;
            }
            this.eUb = eTX;
            this.title = TbadkCoreApplication.getInst().getResources().getString(d.j.agree_my_post);
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
            this.eUc = feedData.getIsFloor();
            this.postFrom = feedData.getPostFrom();
            this.quote_pid = feedData.getQuote_pid();
            this.isNew = feedData.isNew();
            this.originalThreadInfo = new OriginalThreadInfo();
            this.originalThreadInfo.threadId = this.thread_id;
            this.originalThreadInfo.threadType = this.threadType;
            this.originalThreadInfo.showPicUrl = feedData.getThreadImgUrl();
            this.eUd = "c12928";
            if (feedData.getType() == 1) {
                this.originalThreadInfo.postId = feedData.getQuote_pid();
                String str = "";
                if (feedData.getQuote_user() != null) {
                    if (am.equals(feedData.getQuote_user().getUserId(), TbadkCoreApplication.getCurrentAccount())) {
                        str = TbadkCoreApplication.getInst().getString(d.j.me);
                    } else {
                        str = feedData.getQuote_user().getName_show();
                    }
                }
                this.originalThreadInfo.title = TbadkCoreApplication.getInst().getString(d.j.reply_me_original, new Object[]{str, feedData.getQuote_content()});
                if (TextUtils.isGraphic(this.originalThreadInfo.title)) {
                    this.originalThreadInfo.title = this.originalThreadInfo.title.replace("\n", " ");
                }
                if (feedData.getIsFloor()) {
                    this.eUb = eTY;
                } else {
                    this.eUb = eTZ;
                }
            } else {
                this.originalThreadInfo.postId = "0";
                if (feedData.isShareThread() && feedData.getOriginalThreadInfo() != null) {
                    this.originalThreadInfo.title = TbadkCoreApplication.getInst().getString(d.j.share_replyme_original, new Object[]{feedData.getOriginalThreadInfo().showText});
                } else {
                    this.originalThreadInfo.title = feedData.getTitle();
                }
                this.eUb = eUa;
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

    public int getThreadType() {
        return this.threadType;
    }

    public boolean aNO() {
        return this.eUc;
    }

    public String aNP() {
        return this.quote_pid;
    }

    public boolean isNew() {
        return this.isNew;
    }

    public void il(boolean z) {
        this.isNew = z;
    }

    public String aNQ() {
        return this.eUd;
    }
}
