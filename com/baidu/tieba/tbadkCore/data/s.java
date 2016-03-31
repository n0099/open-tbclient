package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.x;
import com.baidu.tieba.t;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.AddPostList;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SubPost;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.u, ak {
    @Deprecated
    private String authorId;
    private String bimg_url;
    private com.baidu.tbadk.widget.richText.n der;
    private SmallTailInfo dpI;
    private String epQ;
    private ArrayList<s> epS;
    private ArrayList<s> epV;
    private int epW;
    private com.baidu.tbadk.data.a eqa;
    private com.baidu.tbadk.data.e eqb;
    private i eqd;
    private String eqe;
    private String eqf;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId epG = BdUniqueId.gen();
    public static final BdUniqueId epH = BdUniqueId.gen();
    public static final BdUniqueId VR = BdUniqueId.gen();
    public static final BdUniqueId epI = BdUniqueId.gen();
    public static final BdUniqueId epJ = BdUniqueId.gen();
    public static final BdUniqueId UX = BdUniqueId.gen();
    public static final BdUniqueId epK = BdUniqueId.gen();
    public static final BdUniqueId epL = BdUniqueId.gen();
    public static final BdUniqueId epM = BdUniqueId.gen();
    public static final BdUniqueId epN = BdUniqueId.gen();
    public static final BdUniqueId dcW = BdUniqueId.gen();
    private int epO = 0;
    private boolean epT = false;
    private com.baidu.tbadk.widget.richText.a cBl = null;
    private boolean epZ = false;
    private boolean eqc = false;
    private String id = null;
    private String title = null;
    private int epP = 0;
    private long time = 0;
    private String date = null;
    private MetaData author = new MetaData();
    private ArrayList<l> cyY = new ArrayList<>();
    private ArrayList<l> czN = new ArrayList<>();
    private int epR = 0;
    private int epU = 0;
    private int VE = 0;
    private PraiseData praise = new PraiseData();
    private ad epX = new ad();
    private c epY = new c();
    private ArrayList<com.baidu.tbadk.data.a> VP = new ArrayList<>();

    public s() {
        this.epS = null;
        this.epV = null;
        this.epS = new ArrayList<>();
        this.epV = new ArrayList<>();
    }

    public c aTn() {
        return this.epY;
    }

    public ArrayList<s> aTo() {
        return this.epS;
    }

    public void aTp() {
        this.epR++;
    }

    public void aTq() {
        this.epR--;
    }

    public void pr(int i) {
        this.epR = i;
    }

    public ArrayList<s> aTr() {
        return this.epV;
    }

    public boolean isGiftPost() {
        return this.eqc;
    }

    public void setIsGiftPost(boolean z) {
        this.eqc = z;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int aTs() {
        return this.epP;
    }

    public void ps(int i) {
        this.epP = i;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
        this.date = ay.w(j);
    }

    public String aTt() {
        return this.date;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public com.baidu.tbadk.widget.richText.a amn() {
        return this.cBl;
    }

    public void f(com.baidu.tbadk.widget.richText.a aVar) {
        this.cBl = aVar;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public com.baidu.tbadk.data.a aTu() {
        return this.eqa;
    }

    public SmallTailInfo aAu() {
        return this.dpI;
    }

    public void a(SmallTailInfo smallTailInfo) {
        this.dpI = smallTailInfo;
    }

    public com.baidu.tbadk.data.e aTv() {
        return this.eqb;
    }

    public void b(TbPageContext tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        x xVar;
        com.baidu.tbadk.widget.richText.c cVar;
        Bitmap cR;
        if (tbPageContext != null && this.cBl != null && this.cBl.Im() != null) {
            BdUniqueId uniqueId = tbPageContext.getUniqueId();
            ArrayList<IconData> tShowInfoNew = getAuthor().getTShowInfoNew();
            if (tShowInfoNew != null) {
                tShowInfoNew.size();
            }
            String str3 = z ? " [host]" : "";
            int dimensionPixelSize = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds36);
            ArrayList arrayList = new ArrayList();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.e eVar = new com.baidu.adp.widget.e(new t(this, it.next(), uniqueId), 0, 1);
                    eVar.c(0, 0, TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(t.e.small_icon_width), TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(t.e.small_icon_height));
                    arrayList.add(eVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(i);
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.author == null) {
                str = null;
                spannableString = new SpannableString(String.valueOf(sb2) + str3 + "：");
                str2 = null;
            } else {
                spannableString = new SpannableString(String.valueOf(sb2) + this.author.getName_show() + str3 + "：");
                str = this.author.getUserName();
                str2 = this.author.getUserId();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                spannableString.setSpan(arrayList.get(i2), i2, i2 + 1, 17);
            }
            int length = spannableString.length();
            a aVar = new a(tbPageContext.getPageActivity(), str, str2);
            if (z && (cR = at.cR(t.f.icon_floorhost)) != null) {
                int width = (cR.getWidth() * dimensionPixelSize) / cR.getHeight();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cR);
                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                com.baidu.tbadk.widget.f fVar = new com.baidu.tbadk.widget.f(bitmapDrawable);
                if (this.author != null) {
                    spannableString.setSpan(fVar, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                } else {
                    spannableString.setSpan(fVar, sb2.length(), str3.length() + sb2.length(), 17);
                }
            }
            spannableString.setSpan(aVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> Im = this.cBl.Im();
            if (Im != null && Im.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar2 = Im.get(0);
                if (cVar2.Is() != null) {
                    cVar2.fw(sb.length());
                    cVar2.Is().insert(0, (CharSequence) spannableString);
                    return;
                }
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= Im.size()) {
                        xVar = null;
                        break;
                    } else if (Im.get(i4) == null || Im.get(i4).getType() != 512) {
                        i3 = i4 + 1;
                    } else {
                        x It = Im.get(i4).It();
                        Im.remove(i4);
                        xVar = It;
                        break;
                    }
                }
                if (xVar != null) {
                    cVar = new com.baidu.tbadk.widget.richText.c(768);
                    cVar.a(xVar);
                } else {
                    cVar = new com.baidu.tbadk.widget.richText.c(1);
                }
                cVar.fw(sb.length());
                cVar.append(spannableString);
                Im.add(0, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable g(com.baidu.adp.widget.a.a aVar) {
        Bitmap mK;
        if (aVar == null || (mK = aVar.mK()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(mK);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(t.e.ds36), TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(t.e.ds36));
        return bitmapDrawable;
    }

    public int aTw() {
        return this.epR;
    }

    public int aTx() {
        return this.epU;
    }

    public void aM(Context context) {
        int type;
        int i;
        int i2;
        if (this.cyY != null) {
            int i3 = -1;
            int size = this.czN.size();
            if (size > 0) {
                try {
                    i3 = this.czN.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.cyY.size()) {
                l lVar = this.cyY.get(i4);
                if (l.ba(i5, lVar.getType())) {
                    this.czN.get(size - 1).b(lVar.aL(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (lVar.getType() == 3 || lVar.getType() == 2 || lVar.getType() == 11) {
                        this.czN.add(lVar);
                        type = lVar.getType();
                    } else {
                        l lVar2 = new l();
                        lVar2.setType(0);
                        lVar2.b(lVar.aL(context));
                        this.czN.add(lVar2);
                        type = 0;
                    }
                    i = type;
                    i2 = size + 1;
                }
                i4++;
                i5 = i;
                size = i2;
            }
        }
    }

    public void aN(Context context) {
        try {
            if (this.cBl != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.cBl.toString());
                clipboardManager.getText();
                return;
            }
            if (this.czN == null || this.czN.size() == 0) {
                aM(context);
            }
            ArrayList<l> arrayList = this.czN;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.getType() == 0) {
                        if (next.aTa() != null) {
                            sb.append((CharSequence) next.aTa());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(t.j.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(t.j.voice_str));
                    } else if (next.getType() == 2) {
                        String fn = TbFaceManager.EN().fn(next.getText());
                        if (fn != null) {
                            sb.append("[");
                            sb.append(fn);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !ay.isEmpty(next.aSZ())) {
                        sb.append("[").append(next.aSZ()).append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                clipboardManager2.getText();
            }
        } catch (NullPointerException e) {
            BdLog.detailException(e);
        }
    }

    public void a(SubPostList subPostList, Context context) {
        a(subPostList, context, false);
    }

    public void a(SubPostList subPostList, Context context, boolean z) {
        MetaData metaData;
        if (subPostList != null) {
            try {
                this.id = String.valueOf(subPostList.id);
                this.title = subPostList.title;
                this.epP = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.date = ay.w(this.time);
                this.authorId = String.valueOf(subPostList.author_id);
                this.eqc = subPostList.is_giftpost.intValue() == 1;
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.cBl = TbRichTextView.b(context, subPostList.content, z);
                if (this.cBl != null) {
                    this.cBl.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void a(Post post, Context context) {
        if (post != null) {
            try {
                this.id = String.valueOf(post.id);
                this.title = post.title;
                this.epP = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.date = ay.w(this.time);
                this.epQ = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0")) {
                    MetaData metaData = this.userMap.get(this.authorId);
                    if (metaData != null) {
                        this.author = metaData;
                    }
                } else {
                    this.author.parserProtobuf(post.author);
                }
                if (this.author != null && context != null) {
                    this.eqe = String.valueOf(this.author.getUserName()) + context.getResources().getString(t.j.whose_head_image);
                    this.eqf = String.format(TbadkCoreApplication.m411getInst().getString(t.j.degree_in_forum), Integer.valueOf(this.author.getLevel_id()));
                }
                this.epZ = post.is_ntitle.intValue() == 1;
                this.epR = post.sub_post_number.intValue();
                this.epU = post.add_post_number.intValue();
                this.eqd = new i(post.tpoint_post);
                this.cBl = TbRichTextView.b(context, post.content, true);
                if (this.cBl != null) {
                    this.cBl.setPostId(com.baidu.adp.lib.h.b.c(this.id, -1L));
                    this.cBl.fv(this.epP);
                    if (this.author != null) {
                        this.cBl.setAuthorId(this.author.getUserId());
                    }
                }
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            SubPostList subPostList = list.get(i);
                            s sVar = new s();
                            sVar.eqc = subPostList.is_giftpost.intValue() == 1;
                            sVar.setUserMap(this.userMap);
                            sVar.a(subPostList, context);
                            this.epS.add(sVar);
                        }
                    }
                }
                AddPostList addPostList = post.add_post_list;
                if (addPostList != null) {
                    List<SubPostList> list2 = addPostList.add_post_list;
                    if (list2.size() > 0) {
                        for (SubPostList subPostList2 : list2) {
                            s sVar2 = new s();
                            sVar2.setUserMap(this.userMap);
                            sVar2.a(subPostList2, context);
                            this.epV.add(sVar2);
                        }
                    }
                }
                ActPost actPost = post.act_post;
                if (actPost != null) {
                    this.epY.a(actPost);
                }
                this.bimg_url = post.bimg_url;
                if (this.epV.size() >= 5) {
                    this.epW = 5;
                } else {
                    this.epW = this.epV.size();
                }
                if (post.tail_info != null) {
                    this.eqa = new com.baidu.tbadk.data.a();
                    this.eqa.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.eqb = new com.baidu.tbadk.data.e();
                    this.eqb.a(post.lbs_info);
                }
                this.VE = post.storecount.intValue();
                this.epX.a(post.present);
                this.praise.setUserMap(this.userMap);
                this.praise.parserProtobuf(post.zan);
                if (post.signature != null) {
                    this.dpI = new SmallTailInfo();
                    this.dpI.id = post.signature.signature_id.intValue();
                    this.dpI.color = post.signature.fontColor;
                    if (post.signature.content != null && post.signature.content.size() != 0) {
                        this.dpI.content = new ArrayList();
                        for (SignatureContent signatureContent : post.signature.content) {
                            List<SmallTailInfo.SmallTailInfoContent> list3 = this.dpI.content;
                            SmallTailInfo smallTailInfo = new SmallTailInfo();
                            smallTailInfo.getClass();
                            list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                        }
                    }
                    this.dpI.updateShowInfo();
                }
                if (post.ext_tails != null) {
                    for (int i2 = 0; i2 != post.ext_tails.size(); i2++) {
                        com.baidu.tbadk.data.a aVar = new com.baidu.tbadk.data.a();
                        aVar.a(post.ext_tails.get(i2));
                        this.VP.add(aVar);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends ClickableSpan {
        private SoftReference<Context> eql;
        private String mId;
        private String mName;

        public a(Context context, String str, String str2) {
            this.mName = null;
            this.mId = null;
            this.mName = str;
            this.mId = str2;
            this.eql = new SoftReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (this.eql != null) {
                textPaint.setColor(at.getColor(t.d.cp_link_tip_c));
            }
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (this.mName != null && this.mId != null && this.eql != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(this.eql.get(), this.mId, this.mName, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
            }
        }
    }

    public String aO(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> Im;
        if (this.cBl == null || (Im = this.cBl.Im()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = Im.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Is().toString());
            } else if (next.getType() == 17) {
                String str = next.Iw().axx.awY;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(t.j.msglist_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(t.j.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(t.j.msglist_video) + "]");
            } else if (next.getType() == 1536) {
                stringBuffer.append("[" + context.getString(t.j.msglist_graffiti) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public int aTy() {
        return this.epW;
    }

    public void pu(int i) {
        this.epW = i;
    }

    public aj aTz() {
        ArrayList<com.baidu.tbadk.widget.richText.c> Im;
        if (this.cBl != null && (Im = this.cBl.Im()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = Im.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    aj ajVar = new aj();
                    ajVar.width = next.Ir().getWidth();
                    ajVar.height = next.Ir().getHeight();
                    ajVar.imgUrl = next.Ir().IE();
                    ajVar.abD = 17;
                    return ajVar;
                } else if (next.getType() == 1536) {
                    if (next.IA() == null || TextUtils.isEmpty(next.IA().url)) {
                        return null;
                    }
                    aj ajVar2 = new aj();
                    ajVar2.imgUrl = next.IA().url;
                    ajVar2.abD = 17;
                    return ajVar2;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.ak
    public ArrayList<aj> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> Im;
        if (this.cBl == null || (Im = this.cBl.Im()) == null) {
            return null;
        }
        ArrayList<aj> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = Im.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                aj ajVar = new aj();
                ajVar.width = next.Ir().getWidth();
                ajVar.height = next.Ir().getHeight();
                ajVar.imgUrl = next.Ir().IE();
                ajVar.abD = 17;
                arrayList.add(ajVar);
            } else if (next.Iw() != null) {
                aj ajVar2 = new aj();
                ajVar2.width = next.Iw().axx.axb;
                ajVar2.height = next.Iw().axx.axc;
                ajVar2.abE = next.Iw();
                ajVar2.abD = 20;
                arrayList.add(ajVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.epW) {
                break;
            }
            arrayList.addAll(this.epV.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            aj ajVar3 = new aj();
            ajVar3.imgUrl = this.bimg_url;
            ajVar3.width = 105;
            ajVar3.width = 105;
            ajVar3.abD = 19;
            arrayList.add(ajVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        aj ajVar4 = new aj();
        ajVar4.imgUrl = this.author.getPortrait();
        ajVar4.abD = 12;
        arrayList.add(ajVar4);
        if (this.epV != null) {
            Iterator<s> it2 = this.epV.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (this.epO == 2) {
            return epH;
        }
        if (this.epO == 1) {
            return VR;
        }
        if (this.epO == 36) {
            return epJ;
        }
        if (this.epO == 40) {
            return UX;
        }
        if (this.epO == 41) {
            return epM;
        }
        if (this.eqd != null && this.eqd.epn) {
            int aSU = this.eqd.aSU();
            if (aSU == 2) {
                return epK;
            }
            if (aSU == 1) {
                return epL;
            }
            return epI;
        }
        return epG;
    }

    public boolean aTA() {
        return this.epT;
    }

    public void iJ(boolean z) {
        this.epT = z;
    }

    public void setPostType(int i) {
        this.epO = i;
    }

    public ad aTB() {
        return this.epX;
    }

    public void a(ad adVar) {
        this.epX = adVar;
    }

    public i aTC() {
        return this.eqd;
    }

    public com.baidu.tbadk.widget.richText.n Iv() {
        if (this.der != null) {
            return this.der;
        }
        if (this.cBl != null && y.p(this.cBl.Im()) > 0) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = this.cBl.Im().iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next != null && next.getType() == 32) {
                    this.der = next.Iv();
                    return this.der;
                }
            }
        }
        return null;
    }

    public ArrayList<com.baidu.tbadk.data.a> aTD() {
        return this.VP;
    }

    public String aTE() {
        return this.eqe;
    }

    public String aTF() {
        return this.eqf;
    }
}
