package com.baidu.zeus.bouncycastle;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
/* loaded from: classes.dex */
public class X509Name extends ASN1Encodable {
    private X509NameEntryConverter converter;
    private X509NameElementList elems;
    private ASN1Sequence seq;
    public static final DERObjectIdentifier C = new DERObjectIdentifier("2.5.4.6");
    public static final DERObjectIdentifier O = new DERObjectIdentifier("2.5.4.10");
    public static final DERObjectIdentifier OU = new DERObjectIdentifier("2.5.4.11");
    public static final DERObjectIdentifier T = new DERObjectIdentifier("2.5.4.12");
    public static final DERObjectIdentifier CN = new DERObjectIdentifier("2.5.4.3");
    public static final DERObjectIdentifier SN = new DERObjectIdentifier("2.5.4.5");
    public static final DERObjectIdentifier STREET = new DERObjectIdentifier("2.5.4.9");
    public static final DERObjectIdentifier SERIALNUMBER = SN;
    public static final DERObjectIdentifier L = new DERObjectIdentifier("2.5.4.7");
    public static final DERObjectIdentifier ST = new DERObjectIdentifier("2.5.4.8");
    public static final DERObjectIdentifier SURNAME = new DERObjectIdentifier("2.5.4.4");
    public static final DERObjectIdentifier GIVENNAME = new DERObjectIdentifier("2.5.4.42");
    public static final DERObjectIdentifier INITIALS = new DERObjectIdentifier("2.5.4.43");
    public static final DERObjectIdentifier GENERATION = new DERObjectIdentifier("2.5.4.44");
    public static final DERObjectIdentifier UNIQUE_IDENTIFIER = new DERObjectIdentifier("2.5.4.45");
    public static final DERObjectIdentifier BUSINESS_CATEGORY = new DERObjectIdentifier("2.5.4.15");
    public static final DERObjectIdentifier POSTAL_CODE = new DERObjectIdentifier("2.5.4.17");
    public static final DERObjectIdentifier DN_QUALIFIER = new DERObjectIdentifier("2.5.4.46");
    public static final DERObjectIdentifier PSEUDONYM = new DERObjectIdentifier("2.5.4.65");
    public static final DERObjectIdentifier DATE_OF_BIRTH = new DERObjectIdentifier("1.3.6.1.5.5.7.9.1");
    public static final DERObjectIdentifier PLACE_OF_BIRTH = new DERObjectIdentifier("1.3.6.1.5.5.7.9.2");
    public static final DERObjectIdentifier GENDER = new DERObjectIdentifier("1.3.6.1.5.5.7.9.3");
    public static final DERObjectIdentifier COUNTRY_OF_CITIZENSHIP = new DERObjectIdentifier("1.3.6.1.5.5.7.9.4");
    public static final DERObjectIdentifier COUNTRY_OF_RESIDENCE = new DERObjectIdentifier("1.3.6.1.5.5.7.9.5");
    public static final DERObjectIdentifier NAME_AT_BIRTH = new DERObjectIdentifier("1.3.36.8.3.14");
    public static final DERObjectIdentifier POSTAL_ADDRESS = new DERObjectIdentifier("2.5.4.16");
    public static final DERObjectIdentifier EmailAddress = PKCSObjectIdentifiers.pkcs_9_at_emailAddress;
    public static final DERObjectIdentifier UnstructuredName = PKCSObjectIdentifiers.pkcs_9_at_unstructuredName;
    public static final DERObjectIdentifier UnstructuredAddress = PKCSObjectIdentifiers.pkcs_9_at_unstructuredAddress;
    public static final DERObjectIdentifier E = EmailAddress;
    public static final DERObjectIdentifier DC = new DERObjectIdentifier("0.9.2342.19200300.100.1.25");
    public static final DERObjectIdentifier UID = new DERObjectIdentifier("0.9.2342.19200300.100.1.1");
    public static Hashtable OIDLookUp = new Hashtable();
    public static boolean DefaultReverse = false;
    public static Hashtable DefaultSymbols = OIDLookUp;
    public static Hashtable RFC2253Symbols = new Hashtable();
    public static Hashtable RFC1779Symbols = new Hashtable();
    public static Hashtable SymbolLookUp = new Hashtable();
    public static Hashtable DefaultLookUp = SymbolLookUp;

    static {
        DefaultSymbols.put(C, "C");
        DefaultSymbols.put(O, "O");
        DefaultSymbols.put(T, "T");
        DefaultSymbols.put(OU, "OU");
        DefaultSymbols.put(CN, "CN");
        DefaultSymbols.put(L, "L");
        DefaultSymbols.put(ST, "ST");
        DefaultSymbols.put(SN, "SN");
        DefaultSymbols.put(EmailAddress, "E");
        DefaultSymbols.put(DC, "DC");
        DefaultSymbols.put(UID, "UID");
        DefaultSymbols.put(STREET, "STREET");
        DefaultSymbols.put(SURNAME, "SURNAME");
        DefaultSymbols.put(GIVENNAME, "GIVENNAME");
        DefaultSymbols.put(INITIALS, "INITIALS");
        DefaultSymbols.put(GENERATION, "GENERATION");
        DefaultSymbols.put(UnstructuredAddress, "unstructuredAddress");
        DefaultSymbols.put(UnstructuredName, "unstructuredName");
        DefaultSymbols.put(UNIQUE_IDENTIFIER, "UniqueIdentifier");
        DefaultSymbols.put(DN_QUALIFIER, "DN");
        DefaultSymbols.put(PSEUDONYM, "Pseudonym");
        DefaultSymbols.put(POSTAL_ADDRESS, "PostalAddress");
        DefaultSymbols.put(NAME_AT_BIRTH, "NameAtBirth");
        DefaultSymbols.put(COUNTRY_OF_CITIZENSHIP, "CountryOfCitizenship");
        DefaultSymbols.put(COUNTRY_OF_RESIDENCE, "CountryOfResidence");
        DefaultSymbols.put(GENDER, "Gender");
        DefaultSymbols.put(PLACE_OF_BIRTH, "PlaceOfBirth");
        DefaultSymbols.put(DATE_OF_BIRTH, "DateOfBirth");
        DefaultSymbols.put(POSTAL_CODE, "PostalCode");
        DefaultSymbols.put(BUSINESS_CATEGORY, "BusinessCategory");
        RFC2253Symbols.put(C, "C");
        RFC2253Symbols.put(O, "O");
        RFC2253Symbols.put(OU, "OU");
        RFC2253Symbols.put(CN, "CN");
        RFC2253Symbols.put(L, "L");
        RFC2253Symbols.put(ST, "ST");
        RFC2253Symbols.put(STREET, "STREET");
        RFC2253Symbols.put(DC, "DC");
        RFC2253Symbols.put(UID, "UID");
        RFC1779Symbols.put(C, "C");
        RFC1779Symbols.put(O, "O");
        RFC1779Symbols.put(OU, "OU");
        RFC1779Symbols.put(CN, "CN");
        RFC1779Symbols.put(L, "L");
        RFC1779Symbols.put(ST, "ST");
        RFC1779Symbols.put(STREET, "STREET");
        DefaultLookUp.put("c", C);
        DefaultLookUp.put("o", O);
        DefaultLookUp.put("t", T);
        DefaultLookUp.put("ou", OU);
        DefaultLookUp.put("cn", CN);
        DefaultLookUp.put("l", L);
        DefaultLookUp.put("st", ST);
        DefaultLookUp.put("sn", SN);
        DefaultLookUp.put("serialnumber", SN);
        DefaultLookUp.put("street", STREET);
        DefaultLookUp.put("emailaddress", E);
        DefaultLookUp.put("dc", DC);
        DefaultLookUp.put("e", E);
        DefaultLookUp.put("uid", UID);
        DefaultLookUp.put("surname", SURNAME);
        DefaultLookUp.put("givenname", GIVENNAME);
        DefaultLookUp.put("initials", INITIALS);
        DefaultLookUp.put("generation", GENERATION);
        DefaultLookUp.put("unstructuredaddress", UnstructuredAddress);
        DefaultLookUp.put("unstructuredname", UnstructuredName);
        DefaultLookUp.put("uniqueidentifier", UNIQUE_IDENTIFIER);
        DefaultLookUp.put("dn", DN_QUALIFIER);
        DefaultLookUp.put("pseudonym", PSEUDONYM);
        DefaultLookUp.put("postaladdress", POSTAL_ADDRESS);
        DefaultLookUp.put("nameofbirth", NAME_AT_BIRTH);
        DefaultLookUp.put("countryofcitizenship", COUNTRY_OF_CITIZENSHIP);
        DefaultLookUp.put("countryofresidence", COUNTRY_OF_RESIDENCE);
        DefaultLookUp.put("gender", GENDER);
        DefaultLookUp.put("placeofbirth", PLACE_OF_BIRTH);
        DefaultLookUp.put("dateofbirth", DATE_OF_BIRTH);
        DefaultLookUp.put("postalcode", POSTAL_CODE);
        DefaultLookUp.put("businesscategory", BUSINESS_CATEGORY);
    }

    public static X509Name getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static X509Name getInstance(Object obj) {
        if (obj == null || (obj instanceof X509Name)) {
            return (X509Name) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new X509Name((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory \"" + obj.getClass().getName() + "\"");
    }

    public X509Name(ASN1Sequence aSN1Sequence) {
        String str;
        this.converter = null;
        this.elems = new X509NameElementList();
        this.seq = aSN1Sequence;
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1Set aSN1Set = (ASN1Set) objects.nextElement();
            int i = 0;
            while (i < aSN1Set.size()) {
                ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Set.getObjectAt(i);
                DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) aSN1Sequence2.getObjectAt(0);
                DEREncodable objectAt = aSN1Sequence2.getObjectAt(1);
                if (objectAt instanceof DERString) {
                    str = ((DERString) objectAt).getString();
                } else {
                    str = "#" + bytesToString(Hex.encode(objectAt.getDERObject().getDEREncoded()));
                }
                this.elems.add(dERObjectIdentifier, str, i != 0);
                i++;
            }
        }
    }

    public X509Name(Hashtable hashtable) {
        this((Vector) null, hashtable);
    }

    public X509Name(Vector vector, Hashtable hashtable) {
        this(vector, hashtable, new X509DefaultEntryConverter());
    }

    public X509Name(Vector vector, Hashtable hashtable, X509DefaultEntryConverter x509DefaultEntryConverter) {
        DERObjectIdentifier dERObjectIdentifier;
        this.converter = null;
        this.elems = new X509NameElementList();
        this.converter = x509DefaultEntryConverter;
        if (vector != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 == vector.size()) {
                    break;
                }
                dERObjectIdentifier = (DERObjectIdentifier) vector.elementAt(i2);
                String str = (String) hashtable.get(dERObjectIdentifier);
                if (str == null) {
                    break;
                }
                this.elems.add(dERObjectIdentifier, str);
                i = i2 + 1;
            }
            dERObjectIdentifier = null;
        } else {
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                dERObjectIdentifier = (DERObjectIdentifier) keys.nextElement();
                String str2 = (String) hashtable.get(dERObjectIdentifier);
                if (str2 == null) {
                    break;
                }
                this.elems.add(dERObjectIdentifier, str2);
            }
            dERObjectIdentifier = null;
        }
        if (dERObjectIdentifier != null) {
            throw new IllegalArgumentException("No attribute for object id - " + dERObjectIdentifier.getId() + " - passed to distinguished name");
        }
    }

    public X509Name(Vector vector, Vector vector2) {
        this(vector, vector2, new X509DefaultEntryConverter());
    }

    public X509Name(Vector vector, Vector vector2, X509NameEntryConverter x509NameEntryConverter) {
        this.converter = null;
        this.elems = new X509NameElementList();
        this.converter = x509NameEntryConverter;
        if (vector.size() != vector2.size()) {
            throw new IllegalArgumentException("oids vector must be same length as values.");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < vector.size()) {
                this.elems.add((DERObjectIdentifier) vector.elementAt(i2), (String) vector2.elementAt(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public X509Name(String str) {
        this(DefaultReverse, DefaultLookUp, str);
    }

    public X509Name(String str, X509NameEntryConverter x509NameEntryConverter) {
        this(DefaultReverse, DefaultLookUp, str, x509NameEntryConverter);
    }

    public X509Name(boolean z, String str) {
        this(z, DefaultLookUp, str);
    }

    public X509Name(boolean z, String str, X509NameEntryConverter x509NameEntryConverter) {
        this(z, DefaultLookUp, str, x509NameEntryConverter);
    }

    public X509Name(boolean z, Hashtable hashtable, String str) {
        this(z, hashtable, str, new X509DefaultEntryConverter());
    }

    private DERObjectIdentifier decodeOID(String str, Hashtable hashtable) {
        if (Strings.toUpperCase(str).startsWith("OID.")) {
            return new DERObjectIdentifier(str.substring(4));
        }
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            return new DERObjectIdentifier(str);
        }
        DERObjectIdentifier dERObjectIdentifier = (DERObjectIdentifier) hashtable.get(Strings.toLowerCase(str));
        if (dERObjectIdentifier == null) {
            throw new IllegalArgumentException("Unknown object id - " + str + " - passed to distinguished name");
        }
        return dERObjectIdentifier;
    }

    public X509Name(boolean z, Hashtable hashtable, String str, X509NameEntryConverter x509NameEntryConverter) {
        this.converter = null;
        this.elems = new X509NameElementList();
        this.converter = x509NameEntryConverter;
        X509NameTokenizer x509NameTokenizer = new X509NameTokenizer(str);
        while (x509NameTokenizer.hasMoreTokens()) {
            String nextToken = x509NameTokenizer.nextToken();
            int indexOf = nextToken.indexOf(61);
            if (indexOf == -1) {
                throw new IllegalArgumentException("badly formatted directory string");
            }
            String substring = nextToken.substring(0, indexOf);
            String substring2 = nextToken.substring(indexOf + 1);
            DERObjectIdentifier decodeOID = decodeOID(substring, hashtable);
            if (substring2.indexOf(43) > 0) {
                X509NameTokenizer x509NameTokenizer2 = new X509NameTokenizer(substring2, '+');
                this.elems.add(decodeOID, x509NameTokenizer2.nextToken());
                while (x509NameTokenizer2.hasMoreTokens()) {
                    String nextToken2 = x509NameTokenizer2.nextToken();
                    int indexOf2 = nextToken2.indexOf(61);
                    String substring3 = nextToken2.substring(0, indexOf2);
                    this.elems.add(decodeOID(substring3, hashtable), nextToken2.substring(indexOf2 + 1), true);
                }
            } else {
                this.elems.add(decodeOID, substring2);
            }
        }
        if (z) {
            this.elems = this.elems.reverse();
        }
    }

    public Vector getOIDs() {
        Vector vector = new Vector();
        int size = this.elems.size();
        for (int i = 0; i < size; i++) {
            vector.addElement(this.elems.getKey(i));
        }
        return vector;
    }

    public Vector getValues() {
        Vector vector = new Vector();
        int size = this.elems.size();
        for (int i = 0; i < size; i++) {
            vector.addElement(this.elems.getValue(i));
        }
        return vector;
    }

    @Override // com.baidu.zeus.bouncycastle.ASN1Encodable
    public DERObject toASN1Object() {
        if (this.seq == null) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            int size = this.elems.size();
            ASN1EncodableVector aSN1EncodableVector3 = aSN1EncodableVector2;
            DERObjectIdentifier dERObjectIdentifier = null;
            int i = 0;
            while (i != size) {
                ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
                DERObjectIdentifier key = this.elems.getKey(i);
                aSN1EncodableVector4.add(key);
                aSN1EncodableVector4.add(this.converter.getConvertedValue(key, this.elems.getValue(i)));
                if (dERObjectIdentifier == null || this.elems.getAdded(i)) {
                    aSN1EncodableVector3.add(new DERSequence(aSN1EncodableVector4));
                } else {
                    aSN1EncodableVector.add(new DERSet(aSN1EncodableVector3));
                    aSN1EncodableVector3 = new ASN1EncodableVector();
                    aSN1EncodableVector3.add(new DERSequence(aSN1EncodableVector4));
                }
                i++;
                dERObjectIdentifier = key;
            }
            aSN1EncodableVector.add(new DERSet(aSN1EncodableVector3));
            this.seq = new DERSequence(aSN1EncodableVector);
        }
        return this.seq;
    }

    public boolean equals(Object obj, boolean z) {
        if (obj == this) {
            return true;
        }
        if (!z) {
            return equals(obj);
        }
        if (obj instanceof X509Name) {
            X509Name x509Name = (X509Name) obj;
            int size = this.elems.size();
            if (size != x509Name.elems.size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                String id = this.elems.getKey(i).getId();
                String value = this.elems.getValue(i);
                String id2 = x509Name.elems.getKey(i).getId();
                String value2 = x509Name.elems.getValue(i);
                if (!id.equals(id2)) {
                    return false;
                }
                String lowerCase = Strings.toLowerCase(value.trim());
                String lowerCase2 = Strings.toLowerCase(value2.trim());
                if (!lowerCase.equals(lowerCase2)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    if (lowerCase.length() != 0) {
                        char charAt = lowerCase.charAt(0);
                        stringBuffer.append(charAt);
                        char c = charAt;
                        int i2 = 1;
                        while (i2 < lowerCase.length()) {
                            char charAt2 = lowerCase.charAt(i2);
                            if (c != ' ' || charAt2 != ' ') {
                                stringBuffer.append(charAt2);
                            }
                            i2++;
                            c = charAt2;
                        }
                    }
                    if (lowerCase2.length() != 0) {
                        char charAt3 = lowerCase2.charAt(0);
                        stringBuffer2.append(charAt3);
                        char c2 = charAt3;
                        int i3 = 1;
                        while (i3 < lowerCase2.length()) {
                            char charAt4 = lowerCase2.charAt(i3);
                            if (c2 != ' ' || charAt4 != ' ') {
                                stringBuffer2.append(charAt4);
                            }
                            i3++;
                            c2 = charAt4;
                        }
                    }
                    if (!stringBuffer.toString().equals(stringBuffer2.toString())) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.zeus.bouncycastle.ASN1Encodable
    public boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509Name) && !(obj instanceof ASN1Sequence)) {
            return false;
        }
        if (getDERObject().equals(((DEREncodable) obj).getDERObject())) {
            return true;
        }
        if (!(obj instanceof X509Name)) {
            return false;
        }
        X509Name x509Name = (X509Name) obj;
        int size = this.elems.size();
        if (size != x509Name.elems.size()) {
            return false;
        }
        boolean[] zArr = new boolean[size];
        for (int i = 0; i < size; i++) {
            String id = this.elems.getKey(i).getId();
            int i2 = 0;
            String value = this.elems.getValue(i);
            while (true) {
                if (i2 >= size) {
                    z = false;
                    break;
                }
                if (!zArr[i2]) {
                    String id2 = this.elems.getKey(i2).getId();
                    String value2 = x509Name.elems.getValue(i2);
                    if (id.equals(id2)) {
                        String lowerCase = Strings.toLowerCase(value.trim());
                        String lowerCase2 = Strings.toLowerCase(value2.trim());
                        if (lowerCase.equals(lowerCase2)) {
                            zArr[i2] = true;
                            z = true;
                            break;
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        StringBuffer stringBuffer2 = new StringBuffer();
                        if (lowerCase.length() != 0) {
                            char charAt = lowerCase.charAt(0);
                            stringBuffer.append(charAt);
                            int i3 = 1;
                            while (i3 < lowerCase.length()) {
                                char charAt2 = lowerCase.charAt(i3);
                                if (charAt != ' ' || charAt2 != ' ') {
                                    stringBuffer.append(charAt2);
                                }
                                i3++;
                                charAt = charAt2;
                            }
                        }
                        if (lowerCase2.length() != 0) {
                            char charAt3 = lowerCase2.charAt(0);
                            stringBuffer2.append(charAt3);
                            int i4 = 1;
                            while (i4 < lowerCase2.length()) {
                                char charAt4 = lowerCase2.charAt(i4);
                                if (charAt3 != ' ' || charAt4 != ' ') {
                                    stringBuffer2.append(charAt4);
                                }
                                i4++;
                                charAt3 = charAt4;
                            }
                        }
                        if (stringBuffer.toString().equals(stringBuffer2.toString())) {
                            zArr[i2] = true;
                            z = true;
                            break;
                        }
                        value = lowerCase;
                    } else {
                        continue;
                    }
                }
                i2++;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.zeus.bouncycastle.ASN1Encodable
    public int hashCode() {
        Enumeration objects = ((ASN1Sequence) getDERObject()).getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            i ^= objects.nextElement().hashCode();
        }
        return i;
    }

    private void appendValue(StringBuffer stringBuffer, Hashtable hashtable, DERObjectIdentifier dERObjectIdentifier, String str) {
        String str2 = (String) hashtable.get(dERObjectIdentifier);
        if (str2 != null) {
            stringBuffer.append(str2);
        } else {
            stringBuffer.append(dERObjectIdentifier.getId());
        }
        stringBuffer.append('=');
        int length = stringBuffer.length();
        stringBuffer.append(str);
        int length2 = stringBuffer.length();
        while (length != length2) {
            if (stringBuffer.charAt(length) == ',' || stringBuffer.charAt(length) == '\"' || stringBuffer.charAt(length) == '\\' || stringBuffer.charAt(length) == '+' || stringBuffer.charAt(length) == '<' || stringBuffer.charAt(length) == '>' || stringBuffer.charAt(length) == ';') {
                stringBuffer.insert(length, "\\");
                length++;
                length2++;
            }
            length++;
        }
    }

    public String toString(boolean z, Hashtable hashtable) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z2 = true;
        if (z) {
            for (int size = this.elems.size() - 1; size >= 0; size--) {
                if (z2) {
                    z2 = false;
                } else if (this.elems.getAdded(size + 1)) {
                    stringBuffer.append('+');
                } else {
                    stringBuffer.append(',');
                }
                appendValue(stringBuffer, hashtable, this.elems.getKey(size), this.elems.getValue(size));
            }
        } else {
            boolean z3 = true;
            for (int i = 0; i < this.elems.size(); i++) {
                if (z3) {
                    z3 = false;
                } else if (this.elems.getAdded(i)) {
                    stringBuffer.append('+');
                } else {
                    stringBuffer.append(',');
                }
                appendValue(stringBuffer, hashtable, this.elems.getKey(i), this.elems.getValue(i));
            }
        }
        return stringBuffer.toString();
    }

    private String bytesToString(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i != cArr.length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        return new String(cArr);
    }

    public String toString() {
        return toString(DefaultReverse, DefaultSymbols);
    }
}
