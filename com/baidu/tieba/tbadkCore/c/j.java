package com.baidu.tieba.tbadkCore.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.ai;
import com.baidu.adp.widget.p;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.AddPostList;
import tbclient.Post;
import tbclient.SubPost;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class j implements ai, as {
    public static final BdUniqueId cnQ = BdUniqueId.gen();
    private String authorId;
    private String bimg_url;
    private String cnS;
    private ArrayList<j> cnU;
    private ArrayList<j> cnX;
    private int cnZ;
    private com.baidu.tbadk.data.a coa;
    private com.baidu.tbadk.data.d cob;
    private HashMap<String, MetaData> userMap;
    private boolean cnV = false;
    private com.baidu.tbadk.widget.richText.a cnY = null;
    private String id = null;
    private String title = null;
    private int cnR = 0;
    private long time = 0;
    private MetaData author = new MetaData();
    private ArrayList<c> buh = new ArrayList<>();
    private ArrayList<c> buP = new ArrayList<>();
    private int cnT = 0;
    private int cnW = 0;

    public j() {
        this.cnU = null;
        this.cnX = null;
        this.cnU = new ArrayList<>();
        this.cnX = new ArrayList<>();
    }

    public ArrayList<j> amx() {
        return this.cnU;
    }

    public void amy() {
        this.cnT--;
    }

    public void iq(int i) {
        this.cnT = i;
    }

    public ArrayList<j> amz() {
        return this.cnX;
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

    public void setTitle(String str) {
        this.title = str;
    }

    public int amA() {
        return this.cnR;
    }

    public void ir(int i) {
        this.cnR = i;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public void a(MetaData metaData) {
        this.author = metaData;
    }

    public com.baidu.tbadk.widget.richText.a amB() {
        return this.cnY;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public com.baidu.tbadk.data.a amC() {
        return this.coa;
    }

    public com.baidu.tbadk.data.d amD() {
        return this.cob;
    }

    public void b(TbPageContext<?> tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        if (tbPageContext != null && this.cnY != null && this.cnY.Dv() != null) {
            ArrayList<IconData> tShowInfo = getAuthor().getTShowInfo();
            if (tShowInfo != null) {
                tShowInfo.size();
            }
            String str3 = z ? " [host]" : "";
            int dimensionPixelSize = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(t.ds36);
            ArrayList arrayList = new ArrayList();
            if (tShowInfo != null) {
                Iterator<IconData> it = tShowInfo.iterator();
                while (it.hasNext()) {
                    p pVar = new p(new k(this, it.next(), tbPageContext), 0, 1);
                    pVar.c(0, 0, TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(t.small_icon_width), TbadkCoreApplication.m411getInst().getApp().getResources().getDimensionPixelSize(t.small_icon_height));
                    arrayList.add(pVar);
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
            m mVar = new m(this, tbPageContext.getPageActivity(), str, str2);
            if (z) {
                TbadkCoreApplication.m411getInst().getSkinType();
                Bitmap cg = ba.cg(u.icon_floorhost);
                if (cg != null) {
                    int width = (cg.getWidth() * dimensionPixelSize) / cg.getHeight();
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(cg);
                    bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                    ImageSpan imageSpan = new ImageSpan(bitmapDrawable, 1);
                    if (this.author != null) {
                        spannableString.setSpan(imageSpan, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                    } else {
                        spannableString.setSpan(imageSpan, sb2.length(), str3.length() + sb2.length(), 17);
                    }
                }
            }
            spannableString.setSpan(mVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> Dv = this.cnY.Dv();
            if (Dv != null && Dv.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar = Dv.get(0);
                if (cVar.DB() != null) {
                    cVar.eh(sb.length());
                    cVar.DB().insert(0, (CharSequence) spannableString);
                    return;
                }
                com.baidu.tbadk.widget.richText.c cVar2 = new com.baidu.tbadk.widget.richText.c(768);
                cVar2.eh(sb.length());
                cVar2.append(spannableString);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < Dv.size()) {
                        if (Dv.get(i4).getType() != 512) {
                            i3 = i4 + 1;
                        } else {
                            cVar2.a(Dv.get(i4).DC());
                            Dv.remove(i4);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                Dv.add(0, cVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable f(com.baidu.adp.widget.a.a aVar) {
        Bitmap mz;
        if (aVar == null || (mz = aVar.mz()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(mz);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(t.small_icon_width), TbadkCoreApplication.m411getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(t.small_icon_height));
        return bitmapDrawable;
    }

    public int amE() {
        return this.cnT;
    }

    public int amF() {
        return this.cnW;
    }

    public void aD(Context context) {
        int type;
        int i;
        int i2;
        if (this.buh != null) {
            int i3 = -1;
            int size = this.buP.size();
            if (size > 0) {
                try {
                    i3 = this.buP.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.buh.size()) {
                c cVar = this.buh.get(i4);
                if (c.ah(i5, cVar.getType())) {
                    this.buP.get(size - 1).a(cVar.aC(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (cVar.getType() == 3 || cVar.getType() == 2 || cVar.getType() == 11) {
                        this.buP.add(cVar);
                        type = cVar.getType();
                    } else {
                        c cVar2 = new c();
                        cVar2.setType(0);
                        cVar2.a(cVar.aC(context));
                        this.buP.add(cVar2);
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

    public void aE(Context context) {
        try {
            if (this.cnY != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.cnY.toString());
                clipboardManager.getText();
                return;
            }
            if (this.buP == null || this.buP.size() == 0) {
                aD(context);
            }
            ArrayList<c> arrayList = this.buP;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<c> it = arrayList.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.getType() == 0) {
                        if (next.amj() != null) {
                            sb.append((CharSequence) next.amj());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(y.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(y.voice_str));
                    } else if (next.getType() == 2) {
                        String ec = TbFaceManager.zr().ec(next.getText());
                        if (ec != null) {
                            sb.append("[");
                            sb.append(ec);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !bd.isEmpty(next.ami())) {
                        sb.append("[").append(next.ami()).append("]");
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
                this.cnR = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.authorId = String.valueOf(subPostList.author_id);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals(GameInfoData.NOT_FROM_DETAIL) && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals(GameInfoData.NOT_FROM_DETAIL)) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.cnY = TbRichTextView.a(context, subPostList.content, z);
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
                this.cnR = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.cnS = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals(GameInfoData.NOT_FROM_DETAIL)) {
                    MetaData metaData = this.userMap.get(this.authorId);
                    if (metaData != null) {
                        this.author = metaData;
                    }
                } else {
                    this.author.parserProtobuf(post.author);
                }
                this.cnT = post.sub_post_number.intValue();
                this.cnW = post.add_post_number.intValue();
                this.cnY = TbRichTextView.a(context, post.content, true);
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size(); i++) {
                            j jVar = new j();
                            jVar.setUserMap(this.userMap);
                            jVar.a(list.get(i), context);
                            this.cnU.add(jVar);
                        }
                    }
                }
                AddPostList addPostList = post.add_post_list;
                if (addPostList != null) {
                    List<SubPostList> list2 = addPostList.add_post_list;
                    if (list2.size() > 0) {
                        for (SubPostList subPostList : list2) {
                            j jVar2 = new j();
                            jVar2.setUserMap(this.userMap);
                            jVar2.a(subPostList, context);
                            this.cnX.add(jVar2);
                        }
                    }
                }
                this.bimg_url = post.bimg_url;
                if (this.cnX.size() >= 5) {
                    this.cnZ = 5;
                } else {
                    this.cnZ = this.cnX.size();
                }
                if (post.tail_info != null) {
                    this.coa = new com.baidu.tbadk.data.a();
                    this.coa.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.cob = new com.baidu.tbadk.data.d();
                    this.cob.a(post.lbs_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public String aF(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> Dv;
        if (this.cnY == null || (Dv = this.cnY.Dv()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = Dv.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.DB().toString());
            } else if (next.getType() == 17) {
                String str = next.DE().akK.akk;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(y.msglist_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(y.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(y.msglist_video) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public int amG() {
        return this.cnZ;
    }

    public void is(int i) {
        this.cnZ = i;
    }

    public ar amH() {
        ArrayList<com.baidu.tbadk.widget.richText.c> Dv;
        if (this.cnY != null && (Dv = this.cnY.Dv()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = Dv.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    ar arVar = new ar();
                    arVar.width = next.DA().getWidth();
                    arVar.height = next.DA().getHeight();
                    arVar.QK = next.DA().DI();
                    arVar.UU = 17;
                    return arVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.as
    public ArrayList<ar> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> Dv;
        if (this.cnY == null || (Dv = this.cnY.Dv()) == null) {
            return null;
        }
        ArrayList<ar> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = Dv.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                ar arVar = new ar();
                arVar.width = next.DA().getWidth();
                arVar.height = next.DA().getHeight();
                arVar.QK = next.DA().DI();
                arVar.UU = 17;
                arrayList.add(arVar);
            } else if (next.DE() != null) {
                ar arVar2 = new ar();
                arVar2.width = next.DE().akK.ako;
                arVar2.height = next.DE().akK.akp;
                arVar2.UV = next.DE();
                arVar2.UU = 20;
                arrayList.add(arVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.cnZ) {
                break;
            }
            arrayList.addAll(this.cnX.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            ar arVar3 = new ar();
            arVar3.QK = this.bimg_url;
            arVar3.width = 105;
            arVar3.width = 105;
            arVar3.UU = 19;
            arrayList.add(arVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        ar arVar4 = new ar();
        arVar4.QK = this.author.getPortrait();
        arVar4.UU = 12;
        arrayList.add(arVar4);
        if (this.cnX != null) {
            Iterator<j> it2 = this.cnX.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        return arrayList;
    }

    @Override // com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return cnQ;
    }

    public boolean amI() {
        return this.cnV;
    }

    public void eP(boolean z) {
        this.cnV = z;
    }
}
