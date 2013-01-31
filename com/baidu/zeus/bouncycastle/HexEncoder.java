package com.baidu.zeus.bouncycastle;

import java.io.OutputStream;
/* loaded from: classes.dex */
public class HexEncoder implements Encoder {
    protected final byte[] encodingTable = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    protected final byte[] decodingTable = new byte[DERTags.TAGGED];

    protected void initialiseDecodingTable() {
        for (int i = 0; i < this.encodingTable.length; i++) {
            this.decodingTable[this.encodingTable[i]] = (byte) i;
        }
        this.decodingTable[65] = this.decodingTable[97];
        this.decodingTable[66] = this.decodingTable[98];
        this.decodingTable[67] = this.decodingTable[99];
        this.decodingTable[68] = this.decodingTable[100];
        this.decodingTable[69] = this.decodingTable[101];
        this.decodingTable[70] = this.decodingTable[102];
    }

    public HexEncoder() {
        initialiseDecodingTable();
    }

    @Override // com.baidu.zeus.bouncycastle.Encoder
    public int encode(byte[] bArr, int i, int i2, OutputStream outputStream) {
        for (int i3 = i; i3 < i + i2; i3++) {
            int i4 = bArr[i3] & 255;
            outputStream.write(this.encodingTable[i4 >>> 4]);
            outputStream.write(this.encodingTable[i4 & 15]);
        }
        return i2 * 2;
    }

    private boolean ignore(char c) {
        return c == '\n' || c == '\r' || c == '\t' || c == ' ';
    }

    @Override // com.baidu.zeus.bouncycastle.Encoder
    public int decode(byte[] bArr, int i, int i2, OutputStream outputStream) {
        int i3 = i + i2;
        while (i3 > i && ignore((char) bArr[i3 - 1])) {
            i3--;
        }
        int i4 = 0;
        int i5 = i;
        while (i5 < i3) {
            int i6 = i5;
            while (i6 < i3 && ignore((char) bArr[i6])) {
                i6++;
            }
            int i7 = i6 + 1;
            byte b = this.decodingTable[bArr[i6]];
            while (i7 < i3 && ignore((char) bArr[i7])) {
                i7++;
            }
            outputStream.write(this.decodingTable[bArr[i7]] | (b << 4));
            i4++;
            i5 = i7 + 1;
        }
        return i4;
    }

    @Override // com.baidu.zeus.bouncycastle.Encoder
    public int decode(String str, OutputStream outputStream) {
        int i = 0;
        int length = str.length();
        while (length > 0 && ignore(str.charAt(length - 1))) {
            length--;
        }
        int i2 = 0;
        while (i < length) {
            int i3 = i;
            while (i3 < length && ignore(str.charAt(i3))) {
                i3++;
            }
            int i4 = i3 + 1;
            byte b = this.decodingTable[str.charAt(i3)];
            while (i4 < length && ignore(str.charAt(i4))) {
                i4++;
            }
            outputStream.write(this.decodingTable[str.charAt(i4)] | (b << 4));
            i2++;
            i = i4 + 1;
        }
        return i2;
    }
}
