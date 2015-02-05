package com.baidu.tieba.tbadkCore.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.AddPostList;
import tbclient.Post;
import tbclient.SubPost;
import tbclient.SubPostList;
/* loaded from: classes.dex */
public class k implements au {
    private String authorId;
    private String bYH;
    private ArrayList<k> bYJ;
    private ArrayList<k> bYL;
    private int bYN;
    private com.baidu.tbadk.data.a bYO;
    private com.baidu.tbadk.data.d bYP;
    private String bimg_url;
    private HashMap<String, MetaData> userMap;
    private com.baidu.tbadk.widget.richText.a bYM = null;
    private String id = null;
    private String title = null;
    private int bYG = 0;
    private long time = 0;
    private MetaData author = new MetaData();
    private ArrayList<c> brx = new ArrayList<>();
    private ArrayList<c> bsd = new ArrayList<>();
    private int bYI = 0;
    private int bYK = 0;

    public k() {
        this.bYJ = null;
        this.bYL = null;
        this.bYJ = new ArrayList<>();
        this.bYL = new ArrayList<>();
    }

    public ArrayList<k> ahq() {
        return this.bYJ;
    }

    public void ahr() {
        this.bYI--;
    }

    public void hW(int i) {
        this.bYI = i;
    }

    public ArrayList<k> ahs() {
        return this.bYL;
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

    public int aht() {
        return this.bYG;
    }

    public void hX(int i) {
        this.bYG = i;
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

    public com.baidu.tbadk.widget.richText.a ahu() {
        return this.bYM;
    }

    public String getBimg_url() {
        return this.bimg_url;
    }

    public com.baidu.tbadk.data.a ahv() {
        return this.bYO;
    }

    public com.baidu.tbadk.data.d ahw() {
        return this.bYP;
    }

    public void a(TbPageContext<?> tbPageContext, boolean z) {
        String str;
        SpannableString spannableString;
        String str2;
        if (tbPageContext != null && this.bYM != null && this.bYM.zZ() != null) {
            ArrayList<IconData> tShowInfo = getAuthor().getTShowInfo();
            if (tShowInfo != null) {
                tShowInfo.size();
            }
            String str3 = z ? " [host]" : "";
            int dimensionPixelSize = tbPageContext.getPageActivity().getResources().getDimensionPixelSize(u.ds36);
            ArrayList arrayList = new ArrayList();
            if (tShowInfo != null) {
                Iterator<IconData> it = tShowInfo.iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.m mVar = new com.baidu.tbadk.widget.m(new l(this, it.next(), tbPageContext), 0, 1);
                    mVar.e(0, 0, TbadkCoreApplication.m255getInst().getApp().getResources().getDimensionPixelSize(u.small_icon_width), TbadkCoreApplication.m255getInst().getApp().getResources().getDimensionPixelSize(u.small_icon_height));
                    arrayList.add(mVar);
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
            n nVar = new n(this, tbPageContext.getPageActivity(), str, str2);
            if (z) {
                TbadkCoreApplication.m255getInst().getSkinType();
                Bitmap ce = bc.ce(v.icon_floorhost);
                if (ce != null) {
                    int width = (ce.getWidth() * dimensionPixelSize) / ce.getHeight();
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(ce);
                    bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                    ImageSpan imageSpan = new ImageSpan(bitmapDrawable, 1);
                    if (this.author != null) {
                        spannableString.setSpan(imageSpan, sb2.length() + this.author.getName_show().length() + 1, str3.length() + sb2.length() + this.author.getName_show().length(), 17);
                    } else {
                        spannableString.setSpan(imageSpan, sb2.length(), str3.length() + sb2.length(), 17);
                    }
                }
            }
            spannableString.setSpan(nVar, 0, length, 18);
            ArrayList<com.baidu.tbadk.widget.richText.c> zZ = this.bYM.zZ();
            if (zZ != null && zZ.size() > 0) {
                com.baidu.tbadk.widget.richText.c cVar = zZ.get(0);
                if (cVar.Af() != null) {
                    cVar.ed(sb.length());
                    cVar.Af().insert(0, (CharSequence) spannableString);
                    return;
                }
                com.baidu.tbadk.widget.richText.c cVar2 = new com.baidu.tbadk.widget.richText.c(768);
                cVar2.ed(sb.length());
                cVar2.append(spannableString);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < zZ.size()) {
                        if (zZ.get(i4).getType() != 512) {
                            i3 = i4 + 1;
                        } else {
                            cVar2.a(zZ.get(i4).Ag());
                            zZ.remove(i4);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                zZ.add(0, cVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable f(com.baidu.adp.widget.a.a aVar) {
        Bitmap jc;
        if (aVar == null || (jc = aVar.jc()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(jc);
        bitmapDrawable.setBounds(0, 0, TbadkCoreApplication.m255getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(u.small_icon_width), TbadkCoreApplication.m255getInst().getApp().getApplicationContext().getResources().getDimensionPixelSize(u.small_icon_height));
        return bitmapDrawable;
    }

    public int ahx() {
        return this.bYI;
    }

    public int ahy() {
        return this.bYK;
    }

    public void ay(Context context) {
        int type;
        int i;
        int i2;
        if (this.brx != null) {
            int i3 = -1;
            int size = this.bsd.size();
            if (size > 0) {
                try {
                    i3 = this.bsd.get(size - 1).getType();
                } catch (Exception e) {
                    BdLog.detailException(e);
                    return;
                }
            }
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.brx.size()) {
                c cVar = this.brx.get(i4);
                if (c.ae(i5, cVar.getType())) {
                    this.bsd.get(size - 1).a(cVar.aw(context));
                    i2 = size;
                    i = i5;
                } else {
                    if (cVar.getType() == 3 || cVar.getType() == 2 || cVar.getType() == 11) {
                        this.bsd.add(cVar);
                        type = cVar.getType();
                    } else {
                        c cVar2 = new c();
                        cVar2.setType(0);
                        cVar2.a(cVar.aw(context));
                        this.bsd.add(cVar2);
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

    public void az(Context context) {
        try {
            if (this.bYM != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.bYM.toString());
                clipboardManager.getText();
                return;
            }
            if (this.bsd == null || this.bsd.size() == 0) {
                ay(context);
            }
            ArrayList<c> arrayList = this.bsd;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<c> it = arrayList.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.getType() == 0) {
                        if (next.agV() != null) {
                            sb.append((CharSequence) next.agV());
                        }
                    } else if (next.getType() == 3) {
                        if (next.getLink() != null) {
                            sb.append(context.getString(z.pic_str));
                        }
                    } else if (next.getType() == 6) {
                        sb.append(context.getString(z.voice_str));
                    } else if (next.getType() == 2) {
                        String dY = TbFaceManager.vX().dY(next.getText());
                        if (dY != null) {
                            sb.append("[");
                            sb.append(dY);
                            sb.append("]");
                        }
                    } else if (next.getType() == 11 && !bf.isEmpty(next.agU())) {
                        sb.append("[").append(next.agU()).append("]");
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
                this.bYG = subPostList.floor.intValue();
                this.time = subPostList.time.intValue() * 1000;
                this.authorId = String.valueOf(subPostList.author_id);
                MetaData metaData2 = new MetaData();
                metaData2.parserProtobuf(subPostList.author);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0") && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if ((this.author.getUserId() == null || this.author.getUserId().length() <= 0 || this.author.getUserId().equals("0")) && metaData2 != null) {
                    this.author = metaData2;
                }
                this.bYM = TbRichTextView.a(context, subPostList.content, z);
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
                this.bYG = post.floor.intValue();
                this.time = post.time.intValue() * 1000;
                this.bYH = post.time_ex;
                this.authorId = String.valueOf(post.author_id);
                if (this.authorId != null && this.authorId.length() > 0 && !this.authorId.equals("0")) {
                    MetaData metaData = this.userMap.get(this.authorId);
                    if (metaData != null) {
                        this.author = metaData;
                    }
                } else {
                    this.author.parserProtobuf(post.author);
                }
                this.bYI = post.sub_post_number.intValue();
                this.bYK = post.add_post_number.intValue();
                this.bYM = TbRichTextView.a(context, post.content, true);
                SubPost subPost = post.sub_post_list;
                if (subPost != null) {
                    List<SubPostList> list = subPost.sub_post_list;
                    if (list.size() > 0) {
                        for (int i = 0; i < list.size() && i < 2; i++) {
                            k kVar = new k();
                            kVar.setUserMap(this.userMap);
                            kVar.a(list.get(i), context);
                            this.bYJ.add(kVar);
                        }
                    }
                }
                AddPostList addPostList = post.add_post_list;
                if (addPostList != null) {
                    List<SubPostList> list2 = addPostList.add_post_list;
                    if (list2.size() > 0) {
                        for (SubPostList subPostList : list2) {
                            k kVar2 = new k();
                            kVar2.setUserMap(this.userMap);
                            kVar2.a(subPostList, context);
                            this.bYL.add(kVar2);
                        }
                    }
                }
                this.bimg_url = post.bimg_url;
                if (this.bYL.size() >= 5) {
                    this.bYN = 5;
                } else {
                    this.bYN = this.bYL.size();
                }
                if (post.tail_info != null) {
                    this.bYO = new com.baidu.tbadk.data.a();
                    this.bYO.a(post.tail_info);
                }
                if (post.lbs_info != null) {
                    this.bYP = new com.baidu.tbadk.data.d();
                    this.bYP.a(post.lbs_info);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public String aA(Context context) {
        ArrayList<com.baidu.tbadk.widget.richText.c> zZ;
        if (this.bYM == null || (zZ = this.bYM.zZ()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<com.baidu.tbadk.widget.richText.c> it = zZ.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.Af().toString());
            } else if (next.getType() == 17) {
                String str = next.Ai().aam.ZM;
                if (str != null && str.startsWith("#(") && str.endsWith(")")) {
                    stringBuffer.append("[" + str.substring(2, str.length() - 1) + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(z.msglist_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(z.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(z.msglist_video) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public int ahz() {
        return this.bYN;
    }

    public void hY(int i) {
        this.bYN = i;
    }

    public at ahA() {
        ArrayList<com.baidu.tbadk.widget.richText.c> zZ;
        if (this.bYM != null && (zZ = this.bYM.zZ()) != null) {
            Iterator<com.baidu.tbadk.widget.richText.c> it = zZ.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.widget.richText.c next = it.next();
                if (next.getType() == 8) {
                    at atVar = new at();
                    atVar.width = next.Ae().getWidth();
                    atVar.height = next.Ae().getHeight();
                    atVar.EX = next.Ae().Am();
                    atVar.Jk = 17;
                    return atVar;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.util.au
    public ArrayList<at> getImages() {
        ArrayList<com.baidu.tbadk.widget.richText.c> zZ;
        if (this.bYM == null || (zZ = this.bYM.zZ()) == null) {
            return null;
        }
        ArrayList<at> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.widget.richText.c> it = zZ.iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.widget.richText.c next = it.next();
            if (next.getType() == 8) {
                at atVar = new at();
                atVar.width = next.Ae().getWidth();
                atVar.height = next.Ae().getHeight();
                atVar.EX = next.Ae().Am();
                atVar.Jk = 17;
                arrayList.add(atVar);
            } else if (next.Ai() != null) {
                at atVar2 = new at();
                atVar2.width = next.Ai().aam.ZQ;
                atVar2.height = next.Ai().aam.ZR;
                atVar2.Jl = next.Ai();
                atVar2.Jk = 20;
                arrayList.add(atVar2);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bYN) {
                break;
            }
            arrayList.addAll(this.bYL.get(i2).getImages());
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(this.bimg_url)) {
            at atVar3 = new at();
            atVar3.EX = this.bimg_url;
            atVar3.width = 105;
            atVar3.width = 105;
            atVar3.Jk = 19;
            arrayList.add(atVar3);
        }
        if (this.author == null) {
            return arrayList;
        }
        at atVar4 = new at();
        atVar4.EX = this.author.getPortrait();
        atVar4.Jk = 28;
        arrayList.add(atVar4);
        if (this.bYL != null) {
            Iterator<k> it2 = this.bYL.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getImages());
            }
        }
        return arrayList;
    }
}
