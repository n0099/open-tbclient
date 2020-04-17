package com.baidu.tieba.tblauncher;

import android.net.Uri;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes9.dex */
public class e {
    public static void A(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("tid");
                String queryParameter7 = uri.getQueryParameter("kw");
                String queryParameter8 = uri.getQueryParameter(f.dhx);
                String queryParameter9 = uri.getQueryParameter(f.dhy);
                String queryParameter10 = uri.getQueryParameter(f.dhz);
                String queryParameter11 = uri.getQueryParameter(f.dhA);
                an anVar = new an("c13561");
                anVar.cI("obj_locate", queryParameter2);
                anVar.cI("obj_type", queryParameter3);
                anVar.cI("obj_param1", queryParameter4);
                anVar.cI(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                anVar.cI("tid", queryParameter6);
                anVar.cI("fname", queryParameter7);
                anVar.cI(f.dhx, queryParameter8);
                anVar.cI(f.dhy, queryParameter9);
                anVar.cI(f.dhz, queryParameter10);
                anVar.cI(f.dhA, queryParameter11);
                anVar.cI("obj_source", queryParameter);
                TiebaStatic.log(anVar);
            }
        }
    }

    public static void B(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("kw");
                an anVar = new an("c13561");
                anVar.cI("obj_locate", queryParameter2);
                anVar.cI("obj_type", queryParameter3);
                anVar.cI("obj_param1", queryParameter4);
                anVar.cI(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                anVar.cI("fname", queryParameter6);
                anVar.cI("obj_source", queryParameter);
                TiebaStatic.log(anVar);
            }
        }
    }

    public static void C(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("kw");
                an anVar = new an("c13561");
                anVar.cI("obj_locate", queryParameter2);
                anVar.cI("obj_type", queryParameter3);
                anVar.cI("obj_param1", queryParameter4);
                anVar.cI(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                anVar.cI("fname", queryParameter6);
                anVar.cI("obj_source", queryParameter);
                TiebaStatic.log(anVar);
            }
        }
    }

    public static void D(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                an anVar = new an("c13561");
                anVar.cI("obj_locate", queryParameter2);
                anVar.cI("obj_type", queryParameter3);
                anVar.cI("obj_param1", queryParameter4);
                anVar.cI(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                anVar.cI("obj_source", queryParameter);
                TiebaStatic.log(anVar);
            }
        }
    }
}
